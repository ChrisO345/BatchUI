package io.github.chriso345.batchui.editor.colors;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.lexer.BatchLexerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static io.github.chriso345.batchui.editor.colors.BatchSyntaxHighlighterDefinitions.*;

public class BatchSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] PLAINTEXT = new TextAttributesKey[0];

    @Override @NotNull
    public Lexer getHighlightingLexer() {
        return new BatchLexerAdapter();
    }

    @Override @NotNull
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        String tokenName = tokenType.toString();
        if (Objects.equals(tokenName, "BatchTokenType.COMMAND_TERMINATOR"))
            return COMMAND_TERMINATOR.getKeys();
        if (tokenName.contains("COMMAND"))
            return COMMAND.getKeys();
        if (tokenName.contains("ANNOTATION"))
            return DECORATOR.getKeys();
        if (tokenName.contains("TOKEN"))
            return KEYWORD_TOKENS.getKeys();

        return switch (tokenName) {
            case "BatchTokenType.DECORATOR" -> DECORATOR.getKeys();
            case "BatchTokenType.LABEL_MARKER" -> LABEL_MARK.getKeys(); // TODO: Should this be under the COMMAND type?
            case "BatchTokenType.FUNC_LABEL" -> LABEL.getKeys();

            case "BatchTokenType.COMMENT" -> COMMENT.getKeys();
            case "BatchTokenType.REM_DECORATOR" -> DECORATOR_COMMENT.getKeys();

            case "BatchTokenType.TOGGLE" -> TOGGLE.getKeys();
            case "BatchTokenType.SETLOCAL_PARAMETER" -> SETLOCAL_PARAMETER.getKeys();
            case "BatchTokenType.COMMAND_TERMINATOR" -> COMMAND.getKeys();

            case "BatchTokenType.VARIABLE" -> VARIABLE.getKeys();
            case "BatchTokenType.FOR_VARIABLE" -> FOR_VARIABLE.getKeys();
            case "BatchTokenType.ASSIGNMENT" -> ASSIGNMENT.getKeys();

            case "BatchTokenType.OPEN_PAREN", "BatchTokenType.CLOSE_PAREN" -> BRACKETS.getKeys();
            case "BatchTokenType.COMPARISON_OPERATOR" -> OPERATORS.getKeys();

            case "BatchTokenType.EXTENSION" -> EXTENSIONS.getKeys();
            case "BatchTokenType.NUMERIC" -> NUMERIC.getKeys();
            case "BatchTokenType.ARG_LITERAL" -> ARG_LITERAL.getKeys();
            case "BatchTokenType.STRING" -> STRING.getKeys();
            case "BatchTokenType.DISK_DRIVE" -> DISK_DRIVE.getKeys();

            case "BatchTokenType.PLAINTEXT" -> PLAINTEXT;
            case "BAD_CHARACTER" -> BAD_CHARACTER.getKeys();
            default -> getEmptyKeys(tokenName);
        };
    }

    private TextAttributesKey[] getEmptyKeys(String tokenType) {
        return EMPTY_KEYS;
    }
}
