package io.github.chriso345.batchui.runner;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.NotNullLazyValue;
import io.github.chriso345.batchui.BatchIcons;

public final class BatchRunConfigurationType extends ConfigurationTypeBase {

    static final String ID = "BatchRunConfiguration";

    BatchRunConfigurationType() {
        super(ID, "Batch", "Batch run configuration type",
                NotNullLazyValue.createValue(() -> BatchIcons.FILE));
        addFactory(new BatchConfigurationFactory(this));
    }

}