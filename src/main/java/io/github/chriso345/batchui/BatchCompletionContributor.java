package io.github.chriso345.batchui;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import io.github.chriso345.batchui.psi.BatchTypes;
import org.jetbrains.annotations.NotNull;

public class BatchCompletionContributor extends CompletionContributor {
    BatchCompletionContributor() {
        // COMMANDS
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
    }
}
