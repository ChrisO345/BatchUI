package io.github.chriso345.batchui.editor.colors;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.lexer.BatchLexerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static io.github.chriso345.batchui.editor.colors.BatchSyntaxHighlighterDefinitions.*;

public class BatchSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override @NotNull
    public Lexer getHighlightingLexer() {
        return new BatchLexerAdapter();
    }

    @Override @NotNull
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        System.out.println(tokenType.toString());
        return switch (tokenType.toString()) {
            case "BatchTokenType.SEPARATOR" -> SEPARATOR.getKeys();
            case "BatchTokenType.COMMAND", "BatchTokenType.LABEL_MARKER" -> KEY.getKeys();
            case "BatchTokenType.VALUE" -> VALUE.getKeys();
            case "BatchTokenType.COMMENT" -> COMMENT.getKeys();
            case "BatchTokenType.REM_ANNOTATION" -> REM_ANNOTATION.getKeys();
            case "BatchTokenType.ANNOTATION" -> ANNOTATION.getKeys();
            case "BatchTokenType.TOGGLE" -> TOGGLE.getKeys();
            case "BatchTokenType.FUNC_LABEL" -> FUNC_LABEL.getKeys();
            case "BatchTokenType.CMD_TERMINATOR" -> CMD_TERMINATOR.getKeys();
            case "BatchTokenType.STRING" -> STRING.getKeys();
            case "BAD_CHARACTER" -> BAD_CHARACTER.getKeys();
            default -> EMPTY_KEYS;
        };
    }
}
