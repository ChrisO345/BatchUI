package io.github.chriso345.batchui.psi.impl;

import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.BatchProperty;
import io.github.chriso345.batchui.psi.BatchTypes;

public class BatchPsiImplUtil {
    public static String getKey(BatchProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(BatchTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces FIXME: what is this doing??
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(BatchProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
}
