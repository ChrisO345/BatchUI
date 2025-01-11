package io.github.chriso345.batchui;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

// TODO: move to a better folder location
public class BatchLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        if (!element.toString().contains("ECHO_COMMAND")) {
            return;
        }

        RelatedItemLineMarkerInfo<PsiElement> info = NavigationGutterIconBuilder.create(AllIcons.RunConfigurations.TestState.Run)
                .setTargets(element)
                .setTooltipText("Run Batch file")
                .createLineMarkerInfo(element);

        result.add(info);
    }
}
