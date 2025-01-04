package io.github.chriso345.batchui.settings;

import com.intellij.ui.components.JBPanelWithEmptyText;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AppSettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField myCommentPrefix = new JBTextField();

    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Comment prefix", myCommentPrefix, 1, false)
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
        myCommentPrefix.setText(text);
    }
}
