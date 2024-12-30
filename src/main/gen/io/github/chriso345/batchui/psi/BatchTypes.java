// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.impl.*;

public interface BatchTypes {

  IElementType PROPERTY = new BatchElementType("PROPERTY");

  IElementType COMMENT = new BatchTokenType("COMMENT");
  IElementType CRLF = new BatchTokenType("CRLF");
  IElementType KEY = new BatchTokenType("KEY");
  IElementType SEPARATOR = new BatchTokenType("SEPARATOR");
  IElementType VALUE = new BatchTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new BatchPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
