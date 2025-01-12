package io.github.chriso345.batchui.psi.impl;

import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.BatchLabel;
import io.github.chriso345.batchui.psi.BatchTypes;

public class BatchPsiImplUtil {

    // Label
    public static String getFuncLabel(BatchLabel element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.FUNC_LABEL);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getLabelMarker(BatchLabel element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.LABEL_MARKER);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
}
