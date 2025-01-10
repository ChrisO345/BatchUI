package io.github.chriso345.batchui.settings.components;

import com.intellij.execution.util.ListTableWithButtons;
import com.intellij.ide.ui.laf.darcula.DarculaUIUtil;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.ui.ComponentValidator;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.ui.cellvalidators.ValidatingTableCellRendererWrapper;
import com.intellij.openapi.ui.cellvalidators.ValidationUtils;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.wm.IdeFocusManager;
import com.intellij.ui.ScrollingUtil;
import com.intellij.ui.components.fields.ExtendableTextField;
import com.intellij.ui.table.JBTable;
import com.intellij.util.ui.ColumnInfo;
import com.intellij.util.ui.ListTableModel;
import io.github.chriso345.batchui.settings.BatchSettingsState;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class OverrideCommandCaseTable extends ListTableWithButtons<OverrideCommandCaseTable.Item> {
    private static final Pattern originalPattern = Pattern.compile("^[a-z]+$");
    private static final Pattern overridePattern = Pattern.compile("^[a-zA-Z]+$");
    private static final BiFunction<Object, JComponent, ValidationInfo> originalValidationInfoProducer = (value, component) ->
            (value == null || StringUtil.isEmpty(value.toString()) || originalPattern.matcher(value.toString()).matches()) ?
                    null : new ValidationInfo(value + " error", component);
    private static final BiFunction<Object, JComponent, ValidationInfo> overrideValidationInfoProducer = (value, component) ->
            (value == null || StringUtil.isEmpty(value.toString()) || overridePattern.matcher(value.toString()).matches()) ?
                    null : new ValidationInfo(value + " error", component);

    private static final Disposable validatorsDisposable = Disposer.newDisposable();
    private static final ColumnInfo<Item, String> ORIGINAL_COLUMN = new ColumnInfo<>("Original Command") {
        @Override
        public String valueOf(Item item) {
            return item.originalFormat;
        }

        @Override
        public TableCellEditor getEditor(Item item) {
            return getTableCellEditor(originalValidationInfoProducer);
        }

        @Override
        public TableCellRenderer getRenderer(Item item) {
            JTextField cellEditor = new JTextField();
            cellEditor.putClientProperty(DarculaUIUtil.COMPACT_PROPERTY, Boolean.TRUE);

            // Marked as experimental
            return new ValidatingTableCellRendererWrapper(new DefaultTableCellRenderer()).
                    withCellValidator((value, row, column) -> originalValidationInfoProducer.apply(value, null)).
                    bindToEditorSize(cellEditor::getPreferredSize);
        }

        @Override
        public boolean isCellEditable(Item item) {
            return true;
        }

        @Override
        public void setValue(Item item, String value) {
            item.originalFormat = value;
        }
    };

    private static final ColumnInfo<Item, String> NEW_COLUMN = new ColumnInfo<>("New Case") {
        @Override
        public String valueOf(Item item) {
            return item.newFormat;
        }

        @Override
        public TableCellEditor getEditor(Item item) {
            return getTableCellEditor(overrideValidationInfoProducer);
        }

        @Override
        public TableCellRenderer getRenderer(Item item) {
            JTextField cellEditor = new JTextField();
            cellEditor.putClientProperty(DarculaUIUtil.COMPACT_PROPERTY, Boolean.TRUE);

            // Marked as experimental
            return new ValidatingTableCellRendererWrapper(new DefaultTableCellRenderer()).
                    withCellValidator((value, row, column) -> overrideValidationInfoProducer.apply(value, null)).
                    bindToEditorSize(cellEditor::getPreferredSize);
        }

        @Override
        public boolean isCellEditable(Item item) {
            return true;
        }

        @Override
        public void setValue(Item item, String value) {
            item.newFormat = value;
        }
    };

    @NotNull
    private static TableCellEditor getTableCellEditor(BiFunction<Object, JComponent, ValidationInfo> overrideValidationInfoProducer) {
        ExtendableTextField cellEditor = new ExtendableTextField();
        cellEditor.putClientProperty(DarculaUIUtil.COMPACT_PROPERTY, Boolean.TRUE);

        new ComponentValidator(validatorsDisposable).withValidator(() -> {
            String text = cellEditor.getText();
            boolean hasError = !StringUtil.isEmpty(text);
            ValidationUtils.setExtension(cellEditor, ValidationUtils.ERROR_EXTENSION, hasError);

            return overrideValidationInfoProducer.apply(text, cellEditor);
        }).andRegisterOnDocumentListener(cellEditor).installOn(cellEditor);

        return new DefaultCellEditor(cellEditor);
    }

    public OverrideCommandCaseTable() {
        JBTable table = getTableView();
        table.getEmptyText().clear();
        table.getEmptyText().appendLine("Add a new command to override the case of the command.");
        table.setStriped(false); // TODO: true???
    }

    @Override
    protected ListTableModel createListModel() {
        return new ListTableModel<>(ORIGINAL_COLUMN, NEW_COLUMN);
    }

    @Override
    protected Item createElement() {
        return new Item("", "");
    }

    @Override
    protected boolean isEmpty(Item element) {
        return element.originalFormat.isEmpty() && element.newFormat.isEmpty();
    }

    @Override
    protected Item cloneElement(Item variable) {
        return new Item(variable.originalFormat, variable.newFormat);
    }

    @Override
    protected boolean canDeleteElement(Item selection) {
        return true;
    }

    public void addRow(@NotNull String originalFormat) {
        int index = 0;
        while (index < getTableView().getListTableModel().getRowCount()) {
            if (getTableView().getListTableModel().getItem(index).originalFormat.equals(originalFormat)) {
                break;
            }
            index++;
        }

        getTableView().getListTableModel().insertRow(index, new Item(originalFormat, ""));
        getTableView().clearSelection();
        getTableView().addRowSelectionInterval(index, index);
        ScrollingUtil.ensureIndexIsVisible(getTableView(), index, 0);
        IdeFocusManager.getGlobalInstance().requestFocus(getTableView(), false);
    }

    public void reset() {
        List<Item> rows = new ArrayList<>();
        BatchSettingsState settings = BatchSettingsState.getInstance();
        List<String> originalCommands = settings.originalCommands;
        List<String> overrideCommands = settings.overrideCommands;
        for (int i = 0; i < originalCommands.size(); i++) {
            rows.add(new Item(originalCommands.get(i), overrideCommands.get(i)));
        }
        rows.sort(Comparator.comparing(o -> o.originalFormat));
        setValues(rows);
    }

    public void apply() {
        BatchSettingsState settings = BatchSettingsState.getInstance();
        settings.originalCommands = getOriginalValues();
        settings.overrideCommands = getOverrideValues();
    }

    public List<String> getOriginalValues() {
        List<String> values = new ArrayList<>();
        for (Item item : getTableView().getListTableModel().getItems()) {
            values.add(item.originalFormat);
        }
        return values;
    }

    public List<String> getOverrideValues() {
        List<String> values = new ArrayList<>();
        for (Item item : getTableView().getListTableModel().getItems()) {
            values.add(item.newFormat);
        }
        return values;
    }

    public boolean isModified() {
        return !Arrays.equals(BatchSettingsState.getInstance().originalCommands.toArray(),
                getOriginalValues().toArray());
    }

    static class Item {
        String originalFormat;
        String newFormat;

        Item(@NotNull String originalFormat, @NotNull String newFormat) {
            this.originalFormat = originalFormat;
            this.newFormat = newFormat;
        }
    }
}
