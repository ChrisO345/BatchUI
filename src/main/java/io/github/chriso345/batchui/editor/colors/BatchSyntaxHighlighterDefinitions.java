package io.github.chriso345.batchui.editor.colors;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public enum BatchSyntaxHighlighterDefinitions {
    BAD_CHARACTER(HighlighterColors.BAD_CHARACTER),

    COMMAND(DefaultLanguageHighlighterColors.KEYWORD),
    DECORATOR(DefaultLanguageHighlighterColors.METADATA),
    LABEL_MARK(DefaultLanguageHighlighterColors.KEYWORD),
    LABEL(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION),

    COMMENT(DefaultLanguageHighlighterColors.LINE_COMMENT),
    DECORATOR_COMMENT(DefaultLanguageHighlighterColors.KEYWORD),

    TOGGLE(DefaultLanguageHighlighterColors.CONSTANT),
    SETLOCAL_PARAMETER(DefaultLanguageHighlighterColors.METADATA),

    VARIABLE(DefaultLanguageHighlighterColors.CONSTANT), // Change default??
    ASSIGNMENT(DefaultLanguageHighlighterColors.OPERATION_SIGN),

    EXTENSIONS(DefaultLanguageHighlighterColors.NUMBER),
    NUMERIC(DefaultLanguageHighlighterColors.NUMBER),
    STRING(DefaultLanguageHighlighterColors.STRING),
    ;

    private final TextAttributesKey attributesKey;
    BatchSyntaxHighlighterDefinitions(TextAttributesKey attributesKey) {
        this.attributesKey = attributesKey;
    }

    public String getName() {
        return "BATCH" + this.name();
    }

    public TextAttributesKey getAttributesKey() {
        return attributesKey;
    }

    public TextAttributesKey[] getKeys() {
        return new TextAttributesKey[]{
                createTextAttributesKey(getName(), attributesKey)
        };
    }
}
