package io.github.chriso345.batchui.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.PsiDirectory;
import io.github.chriso345.batchui.BatchIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.project.Project;

public class NewBatchFileAction extends CreateFileFromTemplateAction {
    @Override
    protected void buildDialog(@NotNull Project project, @NotNull PsiDirectory directory, CreateFileFromTemplateDialog.@NotNull Builder builder) {
        builder.setTitle("Batch File")
                .addKind("Batch file", BatchIcons.FILE, "Batch File");
    }

    @Override
    protected @NlsContexts.Command String getActionName(PsiDirectory directory, @NonNls @NotNull String newName, @NonNls String templateName) {
        return "Create Batch File: " + newName;
    }
}
