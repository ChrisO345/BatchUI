package io.github.chriso345.batchui.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import io.github.chriso345.batchui.editor.BatchSettingsEditor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BatchRunConfiguration extends RunConfigurationBase<BatchRunConfigurationOptions> {

    BatchRunConfiguration(Project project,
                                 ConfigurationFactory factory,
                                 String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    protected BatchRunConfigurationOptions getOptions() {
        return (BatchRunConfigurationOptions) super.getOptions();
    }

    public String getScriptName() {
        return getOptions().getScriptName();
    }

    public void setScriptName(String scriptName) {
        getOptions().setScriptName(scriptName);
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new BatchSettingsEditor();
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor,
                                    @NotNull ExecutionEnvironment environment) {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                GeneralCommandLine commandLine =
                        new GeneralCommandLine(getOptions().getScriptName());
                OSProcessHandler processHandler = ProcessHandlerFactory.getInstance()
                        .createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }
}