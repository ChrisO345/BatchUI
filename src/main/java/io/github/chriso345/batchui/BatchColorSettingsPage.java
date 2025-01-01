package io.github.chriso345.batchui;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static io.github.chriso345.batchui.BatchSyntaxHighlighterDefinitions.*;

final class BatchColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("TODO//Key", KEY.getKeys()[0]),
            new AttributesDescriptor("TODO//Separator", SEPARATOR.getKeys()[0]),
            new AttributesDescriptor("TODO//Value", VALUE.getKeys()[0]),

            new AttributesDescriptor("Comments//Line comment", COMMENT.getKeys()[0]),

            new AttributesDescriptor("Decorators", ANNOTATION.getKeys()[0]),

            new AttributesDescriptor("Identifiers//Function label", FUNC_LABEL.getKeys()[0]),
            new AttributesDescriptor("Identifiers//Toggle", TOGGLE.getKeys()[0]),

            new AttributesDescriptor("Bad character", BAD_CHARACTER.getKeys()[0]),
    };

    @Override
    public Icon getIcon() {
        return BatchIcons.FILE;
    }

    @Override @NotNull
    public SyntaxHighlighter getHighlighter() {
        return new BatchSyntaxHighlighter();
    }

    // TODO: update with the correct demo text.
    @Override @NotNull
    public String getDemoText() {
        return """
        :: You are reading the ".properties" entry.
        :: The exclamation mark can also mark text as comments.
        website = https://en.wikipedia.org/
        language = English
        :: The backslash below tells the application to continue reading
        :: the value onto the next line.
        message = Welcome to \\
                  Wikipedia!
        :: Add spaces to the key
        key\\ with\\ spaces = This is the value that could be looked up with the key "key with spaces".
        :: Unicode
        tab : \\u0009
        """;
    }

    @Override @Nullable
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override @NotNull
    public String getDisplayName() {
        return "Batch";
    }

}
