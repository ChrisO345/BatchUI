package io.github.chriso345.batchui.editor.colors;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

final class BatchSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    @Override @NotNull
    public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        return new BatchSyntaxHighlighter();
    }
}
