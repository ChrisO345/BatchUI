package io.github.chriso345.batchui.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import io.github.chriso345.batchui.psi.BatchLabel;
import io.github.chriso345.batchui.psi.BatchTypes;
import io.github.chriso345.batchui.psi.BatchVariable;

public class BatchPsiImplUtil {
    // Variable
    public static String getSetter(BatchVariable element) {
        ASTNode setterNode = element.getNode().findChildByType(BatchTypes.SETTER);
        if (setterNode != null) {
            return setterNode.getText();
        } else {
            return null;
        }
    }
    public static String getKey(BatchVariable element) {
        ASTNode keyNode = element.getNode().findChildByType(BatchTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces FIXME: what is this doing??
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(BatchVariable element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    // Label
    public static String getFuncLabel(BatchLabel element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.FUNC_LABEL);
        if (valueNode != null) {
            System.out.println("getFuncLabel: " + valueNode.getText());
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
