package io.github.chriso345.batchui.editor;

import com.intellij.lang.Commenter;
import io.github.chriso345.batchui.settings.BatchSettingsState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BatchCommenter implements Commenter {
    @Override
    public @Nullable String getLineCommentPrefix() {
        BatchSettingsState settings = BatchSettingsState.getInstance();
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
