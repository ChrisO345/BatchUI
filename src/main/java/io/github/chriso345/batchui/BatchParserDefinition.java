package io.github.chriso345.batchui;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import io.github.chriso345.batchui.psi.BatchFile;
import io.github.chriso345.batchui.psi.BatchTokenSets;
import io.github.chriso345.batchui.psi.BatchTypes;
import org.jetbrains.annotations.NotNull;

final class BatchParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(BatchLanguage.INSTANCE);

    @Override @NotNull
    public Lexer createLexer(Project project) {
        return new BatchLexerAdapter();
    }

    @Override @NotNull
    public PsiParser createParser(Project project) {
        return new BatchParser();
    }

    @Override @NotNull
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override @NotNull
    public TokenSet getCommentTokens() {
        return BatchTokenSets.COMMENTS;
    }

    @Override @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override @NotNull
    public PsiElement createElement(ASTNode node) {
        return BatchTypes.Factory.createElement(node);
    }

    @Override @NotNull
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new BatchFile(viewProvider);
    }
}
