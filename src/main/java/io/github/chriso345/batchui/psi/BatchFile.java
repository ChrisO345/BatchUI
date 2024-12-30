package io.github.chriso345.batchui.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import io.github.chriso345.batchui.BatchFileType;
import io.github.chriso345.batchui.BatchLanguage;
import org.jetbrains.annotations.NotNull;

public class BatchFile extends PsiFileBase {
    public BatchFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, BatchLanguage.INSTANCE);
    }

    @Override @NotNull
    public FileType getFileType() {
        return BatchFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Batch File";
    }
}
