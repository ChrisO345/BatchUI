package io.github.chriso345.batchui;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public enum BatchSyntaxHighlighterDefinitions {
    BAD_CHARACTER(HighlighterColors.BAD_CHARACTER),
    SEPARATOR(DefaultLanguageHighlighterColors.OPERATION_SIGN),
    KEY(DefaultLanguageHighlighterColors.KEYWORD),
    VALUE(DefaultLanguageHighlighterColors.STRING),
    COMMENT(DefaultLanguageHighlighterColors.LINE_COMMENT),
    ANNOTATION(DefaultLanguageHighlighterColors.METADATA),
    TOGGLE(DefaultLanguageHighlighterColors.STATIC_FIELD),
    FUNC_LABEL(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
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
