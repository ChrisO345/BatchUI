// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.impl.*;

public interface BatchTypes {

  IElementType LABEL = new BatchElementType("LABEL");
  IElementType MISC = new BatchElementType("MISC");
  IElementType SET_LOCAL = new BatchElementType("SET_LOCAL");
  IElementType VALUE_TYPES = new BatchElementType("VALUE_TYPES");
  IElementType VARIABLE = new BatchElementType("VARIABLE");

  IElementType ANNOTATION = new BatchTokenType("ANNOTATION");
  IElementType CMD_TERMINATOR = new BatchTokenType("CMD_TERMINATOR");
  IElementType COMMAND = new BatchTokenType("COMMAND");
  IElementType COMMENT = new BatchTokenType("COMMENT");
  IElementType CONSTANT = new BatchTokenType("CONSTANT");
  IElementType CRLF = new BatchTokenType("CRLF");
  IElementType FUNC_LABEL = new BatchTokenType("FUNC_LABEL");
  IElementType LABEL_MARKER = new BatchTokenType("LABEL_MARKER");
  IElementType NUMERIC = new BatchTokenType("NUMERIC");
  IElementType PLAINTEXT = new BatchTokenType("PLAINTEXT");
  IElementType REM_ANNOTATION = new BatchTokenType("REM_ANNOTATION");
  IElementType SEPARATOR = new BatchTokenType("SEPARATOR");
  IElementType SET_LOCAL_COMMAND = new BatchTokenType("SET_LOCAL_COMMAND");
  IElementType SHIFT_EXTENSION = new BatchTokenType("SHIFT_EXTENSION");
  IElementType STRING = new BatchTokenType("STRING");
  IElementType TOGGLE = new BatchTokenType("TOGGLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == LABEL) {
        return new BatchLabelImpl(node);
      }
      else if (type == MISC) {
        return new BatchMiscImpl(node);
      }
      else if (type == SET_LOCAL) {
        return new BatchSetLocalImpl(node);
      }
      else if (type == VALUE_TYPES) {
        return new BatchValueTypesImpl(node);
      }
      else if (type == VARIABLE) {
        return new BatchVariableImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
