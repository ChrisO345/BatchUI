package io.github.chriso345.batchui.contributors;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import io.github.chriso345.batchui.util.BatchCommand;
import io.github.chriso345.batchui.BatchIcons;
import io.github.chriso345.batchui.psi.BatchTypes;
import org.jetbrains.annotations.NotNull;

public class BatchCompletionContributor extends CompletionContributor {
    BatchCompletionContributor() {
        // Annotations
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(BatchTypes.ANNOTATION),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet resultSet) {
                        for (BatchCommand command : BatchCommand.values()) {
                            resultSet.addElement(LookupElementBuilder.create(command.getCommand())
                                    .withIcon(BatchIcons.FILE));
                        }
                    }
                }
        );

        // Toggles
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(BatchTypes.TOGGLE), // TODO: change to fix
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("on")
                                .withIcon(BatchIcons.FILE));
                        resultSet.addElement(LookupElementBuilder.create("off")
                                .withIcon(BatchIcons.FILE));
                    }
                }
        );
    }
}
