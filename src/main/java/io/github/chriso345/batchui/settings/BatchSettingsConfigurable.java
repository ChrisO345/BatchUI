package io.github.chriso345.batchui.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class BatchSettingsConfigurable implements Configurable {
    private BatchSettingsComponent mySettingsComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Batch Plugin Settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new BatchSettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        BatchSettingsState settings = BatchSettingsState.getInstance();
        return !mySettingsComponent.getCommentPrefixText().equals(settings.commentPrefix) ||
                mySettingsComponent.getUpperCaseKeywords() != settings.upperCaseKeywords ||
                mySettingsComponent.getIsModified();
    }

    @Override
    public void apply() {
        BatchSettingsState settings = BatchSettingsState.getInstance();
        settings.commentPrefix = mySettingsComponent.getCommentPrefixText().strip();
        settings.upperCaseKeywords = mySettingsComponent.getUpperCaseKeywords();
        mySettingsComponent.applyOverrideCommands();
    }

    @Override
    public void reset() {
        BatchSettingsState settings = BatchSettingsState.getInstance();
        mySettingsComponent.setCommentPrefixText(settings.commentPrefix);
        mySettingsComponent.setUpperCaseKeywords(settings.upperCaseKeywords);
        mySettingsComponent.setOverrideCommands();
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }
}
