package io.github.chriso345.batchui.psi.impl;

import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.BatchSwitch;
import io.github.chriso345.batchui.psi.BatchTypes;
import io.github.chriso345.batchui.psi.BatchVariable;

public class BatchPsiImplUtil {
    // Variable
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

    // Annotation
    public static String getAnnotation(BatchSwitch element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.ANNOTATION);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getToggle(BatchSwitch element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.TOGGLE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    // Label
    public static String getFuncLabel(BatchSwitch element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.FUNC_LABEL);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getColon(BatchSwitch element) {
        ASTNode valueNode = element.getNode().findChildByType(BatchTypes.COLON);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
}
