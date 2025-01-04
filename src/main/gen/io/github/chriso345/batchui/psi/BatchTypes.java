// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.impl.*;

public interface BatchTypes {

  IElementType LABEL = new BatchElementType("LABEL");
  IElementType VARIABLE = new BatchElementType("VARIABLE");

  IElementType ANNOTATION = new BatchTokenType("ANNOTATION");
  IElementType COMMAND = new BatchTokenType("command");
  IElementType COMMENT = new BatchTokenType("COMMENT");
  IElementType CRLF = new BatchTokenType("CRLF");
  IElementType FUNC_LABEL = new BatchTokenType("FUNC_LABEL");
  IElementType KEY = new BatchTokenType("KEY");
  IElementType LABEL_MARKER = new BatchTokenType("LABEL_MARKER");
  IElementType SEPARATOR = new BatchTokenType("SEPARATOR");
  IElementType SETTER = new BatchTokenType("SETTER");
  IElementType SWITCH = new BatchTokenType("switch");
  IElementType TOGGLE = new BatchTokenType("TOGGLE");
  IElementType VALUE = new BatchTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == LABEL) {
        return new BatchLabelImpl(node);
      }
      else if (type == VARIABLE) {
        return new BatchVariableImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
