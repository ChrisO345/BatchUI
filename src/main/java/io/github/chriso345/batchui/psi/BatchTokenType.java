package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.BatchLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class BatchTokenType extends IElementType {
    public BatchTokenType(@NotNull @NonNls String debugName) {
        super(debugName, BatchLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "BatchTokenType." + super.toString();
    }
}
