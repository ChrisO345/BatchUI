// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.impl.*;

public interface BatchTypes {

  IElementType ANNOTATION_REFERENCE = new BatchElementType("ANNOTATION_REFERENCE");
  IElementType CALL_ARGUMENTS = new BatchElementType("CALL_ARGUMENTS");
  IElementType COMMAND = new BatchElementType("COMMAND");
  IElementType COMMAND_REFERENCE = new BatchElementType("COMMAND_REFERENCE");
  IElementType ECHO_ARGUMENTS = new BatchElementType("ECHO_ARGUMENTS");
  IElementType EXIT_ARGUMENTS = new BatchElementType("EXIT_ARGUMENTS");
  IElementType LABEL = new BatchElementType("LABEL");
  IElementType PREFIX = new BatchElementType("PREFIX");
  IElementType SETLOCAL_ARGUMENTS = new BatchElementType("SETLOCAL_ARGUMENTS");
  IElementType SET_ARGUMENTS = new BatchElementType("SET_ARGUMENTS");
  IElementType SHIFT_ARGUMENTS = new BatchElementType("SHIFT_ARGUMENTS");
  IElementType TYPES_ = new BatchElementType("TYPES_");

  IElementType ASSIGNMENT = new BatchTokenType("ASSIGNMENT");
  IElementType CALL_COMMAND = new BatchTokenType("CALL_COMMAND");
  IElementType COMMAND_TERMINATOR = new BatchTokenType("COMMAND_TERMINATOR");
  IElementType COMMENT = new BatchTokenType("COMMENT");
  IElementType COMMENT_REFERENCE = new BatchTokenType("COMMENT_REFERENCE");
  IElementType CRLF = new BatchTokenType("CRLF");
  IElementType DECORATOR = new BatchTokenType("DECORATOR");
  IElementType ECHO_ANNOTATION = new BatchTokenType("ECHO_ANNOTATION");
  IElementType ECHO_COMMAND = new BatchTokenType("ECHO_COMMAND");
  IElementType ENDLOCAL_COMMAND = new BatchTokenType("ENDLOCAL_COMMAND");
  IElementType EXIT_COMMAND = new BatchTokenType("EXIT_COMMAND");
  IElementType EXTENSION = new BatchTokenType("EXTENSION");
  IElementType FUNC_LABEL = new BatchTokenType("FUNC_LABEL");
  IElementType GOTO_COMMAND = new BatchTokenType("GOTO_COMMAND");
  IElementType LABEL_MARKER = new BatchTokenType("LABEL_MARKER");
  IElementType NUMERIC = new BatchTokenType("NUMERIC");
  IElementType PLAINTEXT = new BatchTokenType("PLAINTEXT");
  IElementType REM_DECORATOR = new BatchTokenType("REM_DECORATOR");
  IElementType SETLOCAL_COMMAND = new BatchTokenType("SETLOCAL_COMMAND");
  IElementType SETLOCAL_PARAMETER = new BatchTokenType("SETLOCAL_PARAMETER");
  IElementType SET_COMMAND = new BatchTokenType("SET_COMMAND");
  IElementType SHIFT_COMMAND = new BatchTokenType("SHIFT_COMMAND");
  IElementType STRING = new BatchTokenType("STRING");
  IElementType TOGGLE = new BatchTokenType("TOGGLE");
  IElementType VARIABLE = new BatchTokenType("VARIABLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATION_REFERENCE) {
        return new BatchAnnotationReferenceImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new BatchCallArgumentsImpl(node);
      }
      else if (type == COMMAND) {
        return new BatchCommandImpl(node);
      }
      else if (type == COMMAND_REFERENCE) {
        return new BatchCommandReferenceImpl(node);
      }
      else if (type == ECHO_ARGUMENTS) {
        return new BatchEchoArgumentsImpl(node);
      }
      else if (type == EXIT_ARGUMENTS) {
        return new BatchExitArgumentsImpl(node);
      }
      else if (type == LABEL) {
        return new BatchLabelImpl(node);
      }
      else if (type == PREFIX) {
        return new BatchPrefixImpl(node);
      }
      else if (type == SETLOCAL_ARGUMENTS) {
        return new BatchSetlocalArgumentsImpl(node);
      }
      else if (type == SET_ARGUMENTS) {
        return new BatchSetArgumentsImpl(node);
      }
      else if (type == SHIFT_ARGUMENTS) {
        return new BatchShiftArgumentsImpl(node);
      }
      else if (type == TYPES_) {
        return new BatchTypes_Impl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
