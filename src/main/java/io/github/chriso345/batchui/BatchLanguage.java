package io.github.chriso345.batchui;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class BatchLanguage extends Language{
    public static final BatchLanguage INSTANCE = new BatchLanguage();

    protected BatchLanguage() {
        super("Batch");
    }
}
