package io.github.chriso345.batchui.settings;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import io.github.chriso345.batchui.BatchIcons;
import io.github.chriso345.batchui.editor.colors.BatchSyntaxHighlighter;
import kotlinx.html.VAR;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static io.github.chriso345.batchui.editor.colors.BatchSyntaxHighlighterDefinitions.*;

final class BatchColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("TODO//Key", COMMAND.getKeys()[0]),
            new AttributesDescriptor("TODO//Separator", ASSIGNMENT.getKeys()[0]),
            new AttributesDescriptor("TODO//Value", VARIABLE.getKeys()[0]),

            new AttributesDescriptor("Comments//Line comment", COMMENT.getKeys()[0]),

            new AttributesDescriptor("Decorators", DECORATOR.getKeys()[0]),

            new AttributesDescriptor("Identifiers//Function label", LABEL_MARK.getKeys()[0]),
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
        :: Allow the use of 'ls' command in Windows
        :: Full support not guaranteed, but basic functionality is provided
        
        @echo off
        setlocal enabledelayedexpansion
        
        :: Default to current directory if no directory is passed
        set DIR=.
        set COUNT=0
        
        :: Parse arguments
        :parse_args
        if "%~1"=="" goto done
        if "%~1"=="-c" (
            set /a COUNT=%2
            shift
            shift
        ) else (
            set DIR=%1
            shift
        )
        goto parse_args
        
        :done
        
        :: Initialize output variable as empty string
        set output=
        
        :: Show files in directory similar to 'ls' command
        set counter=0
        for /f "delims=" %%f in ('dir "%DIR%" /b /a') do (
            if !COUNT! neq 0 (
                set /a counter+=1
                if !counter! leq !COUNT! (
                    if defined output (
                        set output=!output!   %%f
                    ) else (
                        set output=%%f
                    )
                )
            ) else (
                if defined output (
                    set output=!output!   %%f
                ) else (
                    set output=%%f
                )
            )
        )
        
        echo !output!
        endlocal
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
