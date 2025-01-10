package io.github.chriso345.batchui.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@State(
        name = "io.github.chriso345.batchui.settings.AppSettingsState",
        storages = @Storage("BatchUIPluginSettings.xml")
)
public class BatchSettingsState implements PersistentStateComponent<BatchSettingsState> {

    public String commentPrefix = "::";
    public boolean upperCaseKeywords = false;
    public List<String> originalCommands = new ArrayList<>();
    public List<String> overrideCommands = new ArrayList<>();

    public static BatchSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(BatchSettingsState.class);
    }

    @Nullable
    @Override
    public BatchSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull BatchSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}