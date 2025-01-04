package io.github.chriso345.batchui.editor;

import com.intellij.lang.Commenter;
import com.intellij.util.containers.ContainerUtil;
import io.github.chriso345.batchui.settings.AppSettingsState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BatchCommenter implements Commenter {
    @Override
    public @Nullable String getLineCommentPrefix() {
        AppSettingsState settings = AppSettingsState.getInstance();
        return settings.commentPrefix + " ";
    }

    @Override @Nullable
    public String getBlockCommentPrefix() {
        return "";
    }

    @Override @Nullable
    public String getBlockCommentSuffix() {
        return null;
    }

    @Override @Nullable
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override @Nullable
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

    @Override @NotNull
    public List<String> getLineCommentPrefixes() {
        return List.of(":: ", "@rem");
    }
}
