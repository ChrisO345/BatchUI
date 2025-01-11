package io.github.chriso345.batchui.contributors;

import com.intellij.execution.ProgramRunnerUtil;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import io.github.chriso345.batchui.BatchFileType;
import io.github.chriso345.batchui.runner.BatchRunConfiguration;
import io.github.chriso345.batchui.runner.BatchRunConfigurationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BatchRunLineMarkerContributor extends RunLineMarkerContributor implements DumbAware {
    @Override
    public @Nullable Info getInfo(@NotNull PsiElement element) {
        return null;
    }

    @Override
    public @Nullable Info getSlowInfo(@NotNull PsiElement element) {
        if (!element.getParent().toString().contains(BatchFileType.INSTANCE.getName()) || element.getStartOffsetInParent() != 0
                || element.getParent().getFirstChild() != element) {
            return null;
        }
        System.out.println("Element: " + element);

        AnAction[] actions = new AnAction[] {getBatchRunAction(element)};
        return new Info(AllIcons.RunConfigurations.TestState.Run, actions, null);
    }

    private AnAction getBatchRunAction(@NotNull PsiElement element) {
        return new AnAction("Run Batch Configuration") {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                Project project = e.getProject();
                VirtualFile vFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
                if (project == null || vFile == null) {
                    return;
                }

                RunManager runManager = RunManager.getInstance(project);
                RunnerAndConfigurationSettings settings =
                        runManager.createConfiguration("Run: " + vFile.getName(), BatchRunConfigurationType.class);

                BatchRunConfiguration configuration = (BatchRunConfiguration) settings.getConfiguration();
                configuration.setScriptName(vFile.getPath());

                // Execute the configuration.
                ProgramRunnerUtil.executeConfiguration(
                        settings,
                        DefaultRunExecutor.getRunExecutorInstance()
                );
            }
        };
    }
}
