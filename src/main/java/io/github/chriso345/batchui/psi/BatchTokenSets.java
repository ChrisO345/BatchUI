package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.TokenSet;
import it.unimi.dsi.fastutil.ints.T;

public interface BatchTokenSets {
    TokenSet COMMENTS = TokenSet.create(BatchTypes.COMMENT);
}
