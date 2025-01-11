package io.github.chriso345.batchui.editor;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import io.github.chriso345.batchui.runner.BatchRunConfiguration;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class BatchSettingsEditor extends SettingsEditor<BatchRunConfiguration> {
    private final JPanel myPanel;
    private final TextFieldWithBrowseButton scriptPathField;

    public BatchSettingsEditor() {
        scriptPathField = new TextFieldWithBrowseButton();
        scriptPathField.addBrowseFolderListener("Select Script File", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor());

        myPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Script file", scriptPathField)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(@NotNull BatchRunConfiguration s) {
        scriptPathField.setText(s.getScriptName());
    }

    @Override
    protected void applyEditorTo(@NotNull BatchRunConfiguration s) throws ConfigurationException {
        s.setScriptName(scriptPathField.getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        return myPanel;
    }
}
