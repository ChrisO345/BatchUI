package io.github.chriso345.batchui.settings;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBPanelWithEmptyText;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import io.github.chriso345.batchui.settings.components.OverrideCommandCaseTable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class BatchSettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField myCommentPrefix = new JBTextField();
    private final JBCheckBox myUpperCaseKeywords = new JBCheckBox();

    private final OverrideCommandCaseTable table = new OverrideCommandCaseTable();

    public BatchSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Comment prefix", myCommentPrefix, 1, false)
                .addSeparator(5).addVerticalGap(5)
                .addLabeledComponent("Uppercase keywords", myUpperCaseKeywords, 1, false)
                .addSeparator(5).addVerticalGap(5)
                .addLabeledComponent("Override command case", table.getComponent(), 1, true)
                .addComponentFillVertically(new JBPanelWithEmptyText(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JBTextField getPreferredFocusedComponent() {
        return myCommentPrefix;
    }

    @NotNull
    public String getCommentPrefixText() {
        return myCommentPrefix.getText();
    }

    public void setCommentPrefixText(@NotNull String text) {
        // TODO: add a check to ensure the text is not empty
        myCommentPrefix.setText(text);
    }

    public boolean getUpperCaseKeywords() {
        return myUpperCaseKeywords.isSelected();
    }

    public void setUpperCaseKeywords(boolean selected) {
        myUpperCaseKeywords.setSelected(selected);
    }

    public boolean getIsModified() {
        return table.isModified();
    }

    public void applyOverrideCommands() {
        table.apply();
    }

    public void setOverrideCommands() {
        table.reset();
    }
}
