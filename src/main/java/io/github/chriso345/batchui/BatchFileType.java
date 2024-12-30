package io.github.chriso345.batchui;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class BatchFileType extends LanguageFileType {
    public static final BatchFileType INSTANCE = new BatchFileType();

    private BatchFileType() {
        super(BatchLanguage.INSTANCE);
    }

    @Override @NotNull
    public String getName() {
        return "Batch File";
    }

    @Override @NotNull
    public String getDescription() {
        return "Batch language file";
    }

    @Override @NotNull
    public String getDefaultExtension() {
        return "bat";
    }

    @Override @NotNull
    public Icon getIcon() {
        return BatchIcons.FILE;
    }
}
