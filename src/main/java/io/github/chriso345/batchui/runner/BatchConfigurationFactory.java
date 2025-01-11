package io.github.chriso345.batchui.runner;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BatchConfigurationFactory extends ConfigurationFactory {

    BatchConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull String getId() {
        return BatchRunConfigurationType.ID;
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(
            @NotNull Project project) {
        return new BatchRunConfiguration(project, this, "Batch");
    }

    @Nullable
    @Override
    public Class<? extends BaseState> getOptionsClass() {
        return BatchRunConfigurationOptions.class;
    }
}