package io.github.chriso345.batchui;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.psi.BatchTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class BatchSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("BATCH_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("BATCH_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("BATCH_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("BATCH_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("BATCH_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey SWITCH_KEY =
            createTextAttributesKey("BATCH_SWITCH_KEY", DefaultLanguageHighlighterColors.METADATA);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] SWITCH_KEYS = new TextAttributesKey[]{SWITCH_KEY};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override @NotNull
    public Lexer getHighlightingLexer() {
        return new BatchLexerAdapter();
    }

    @Override @NotNull
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return switch (tokenType.toString()) {
            case "BatchTokenType.SEPARATOR" -> SEPARATOR_KEYS;
            case "BatchTokenType.KEY" -> KEY_KEYS;
            case "BatchTokenType.VALUE" -> VALUE_KEYS;
            case "BatchTokenType.COMMENT" -> COMMENT_KEYS;
            case "BatchTokenType.ANNOTATION" -> SWITCH_KEYS;
            case "BAD_CHARACTER" -> BAD_CHAR_KEYS;
            default -> EMPTY_KEYS;
        };
    }
}
