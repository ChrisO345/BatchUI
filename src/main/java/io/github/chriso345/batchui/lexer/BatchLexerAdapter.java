package io.github.chriso345.batchui.lexer;

import com.intellij.lexer.FlexAdapter;

public class BatchLexerAdapter extends FlexAdapter {
    public BatchLexerAdapter() {
        super(new BatchLexer(null));
    }
}
