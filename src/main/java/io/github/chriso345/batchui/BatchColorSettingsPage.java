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

final class BatchColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Key", BatchSyntaxHighlighter.KEY),
            new AttributesDescriptor("Separator", BatchSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Value", BatchSyntaxHighlighter.VALUE),
            new AttributesDescriptor("Bad value", BatchSyntaxHighlighter.BAD_CHARACTER)
//            new AttributesDescriptor("Operators//Plus", MySyntaxHighlighter.PLUS),
//            new AttributesDescriptor("Operators//Minus", MySyntaxHighlighter.MINUS),
//            new AttributesDescriptor("Operators//Advanced//Sigma", MySyntaxHighlighter.SIGMA),
//            new AttributesDescriptor("Operators//Advanced//Pi", MySyntaxHighlighter.PI),
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
