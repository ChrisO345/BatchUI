// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.chriso345.batchui.psi.impl.*;

public interface BatchTypes {

  IElementType ANNOTATION_REFERENCE = new BatchElementType("ANNOTATION_REFERENCE");
  IElementType ASSOC_ARGUMENTS = new BatchElementType("ASSOC_ARGUMENTS");
  IElementType CALL_ARGUMENTS = new BatchElementType("CALL_ARGUMENTS");
  IElementType CHDIR_ARGUMENTS = new BatchElementType("CHDIR_ARGUMENTS");
  IElementType COLLECTION = new BatchElementType("COLLECTION");
  IElementType COMMAND = new BatchElementType("COMMAND");
  IElementType COMMAND_REFERENCE = new BatchElementType("COMMAND_REFERENCE");
  IElementType ECHO_ARGUMENTS = new BatchElementType("ECHO_ARGUMENTS");
  IElementType ELSE_ARGUMENTS = new BatchElementType("ELSE_ARGUMENTS");
  IElementType ERROR_IF = new BatchElementType("ERROR_IF");
  IElementType EXIST_IF = new BatchElementType("EXIST_IF");
  IElementType EXIT_ARGUMENTS = new BatchElementType("EXIT_ARGUMENTS");
  IElementType FOR_ARGUMENTS = new BatchElementType("FOR_ARGUMENTS");
  IElementType IF_ARGUMENTS = new BatchElementType("IF_ARGUMENTS");
  IElementType LABEL = new BatchElementType("LABEL");
  IElementType MORE_ARGUMENTS = new BatchElementType("MORE_ARGUMENTS");
  IElementType OPERATORS = new BatchElementType("OPERATORS");
  IElementType PREFIX = new BatchElementType("PREFIX");
  IElementType SETLOCAL_ARGUMENTS = new BatchElementType("SETLOCAL_ARGUMENTS");
  IElementType SET_ARGUMENTS = new BatchElementType("SET_ARGUMENTS");
  IElementType SHIFT_ARGUMENTS = new BatchElementType("SHIFT_ARGUMENTS");
  IElementType STANDARD_IF = new BatchElementType("STANDARD_IF");
  IElementType TYPES_ = new BatchElementType("TYPES_");
  IElementType UNDEFINED_ARGUMENTS = new BatchElementType("UNDEFINED_ARGUMENTS");

  IElementType ARG_LITERAL = new BatchTokenType("ARG_LITERAL");
  IElementType ASSIGNMENT = new BatchTokenType("ASSIGNMENT");
  IElementType ASSOC_ANNOTATION = new BatchTokenType("ASSOC_ANNOTATION");
  IElementType ASSOC_COMMAND = new BatchTokenType("ASSOC_COMMAND");
  IElementType BREAK_ANNOTATION = new BatchTokenType("BREAK_ANNOTATION");
  IElementType BREAK_COMMAND = new BatchTokenType("BREAK_COMMAND");
  IElementType CALL_ANNOTATION = new BatchTokenType("CALL_ANNOTATION");
  IElementType CALL_COMMAND = new BatchTokenType("CALL_COMMAND");
  IElementType CHDIR_ANNOTATION = new BatchTokenType("CHDIR_ANNOTATION");
  IElementType CHDIR_COMMAND = new BatchTokenType("CHDIR_COMMAND");
  IElementType CLOSE_PAREN = new BatchTokenType("CLOSE_PAREN");
  IElementType COMMAND_TERMINATOR = new BatchTokenType("COMMAND_TERMINATOR");
  IElementType COMMENT = new BatchTokenType("COMMENT");
  IElementType COMMENT_REFERENCE = new BatchTokenType("COMMENT_REFERENCE");
  IElementType COMPARISON_OPERATOR = new BatchTokenType("COMPARISON_OPERATOR");
  IElementType CRLF = new BatchTokenType("CRLF");
  IElementType DECORATOR = new BatchTokenType("DECORATOR");
  IElementType DISK_DRIVE = new BatchTokenType("DISK_DRIVE");
  IElementType DO_COMMAND = new BatchTokenType("DO_COMMAND");
  IElementType ECHO_ANNOTATION = new BatchTokenType("ECHO_ANNOTATION");
  IElementType ECHO_COMMAND = new BatchTokenType("ECHO_COMMAND");
  IElementType ELSE_ANNOTATION = new BatchTokenType("ELSE_ANNOTATION");
  IElementType ELSE_COMMAND = new BatchTokenType("ELSE_COMMAND");
  IElementType ENDLOCAL_ANNOTATION = new BatchTokenType("ENDLOCAL_ANNOTATION");
  IElementType ENDLOCAL_COMMAND = new BatchTokenType("ENDLOCAL_COMMAND");
  IElementType ERRORLEVEL_TOKEN = new BatchTokenType("ERRORLEVEL_TOKEN");
  IElementType EXIST_TOKEN = new BatchTokenType("EXIST_TOKEN");
  IElementType EXIT_ANNOTATION = new BatchTokenType("EXIT_ANNOTATION");
  IElementType EXIT_COMMAND = new BatchTokenType("EXIT_COMMAND");
  IElementType EXTENSION = new BatchTokenType("EXTENSION");
  IElementType FOR_ANNOTATION = new BatchTokenType("FOR_ANNOTATION");
  IElementType FOR_COMMAND = new BatchTokenType("FOR_COMMAND");
  IElementType FOR_VARIABLE = new BatchTokenType("FOR_VARIABLE");
  IElementType FUNC_LABEL = new BatchTokenType("FUNC_LABEL");
  IElementType GOTO_ANNOTATION = new BatchTokenType("GOTO_ANNOTATION");
  IElementType GOTO_COMMAND = new BatchTokenType("GOTO_COMMAND");
  IElementType IF_ANNOTATION = new BatchTokenType("IF_ANNOTATION");
  IElementType IF_COMMAND = new BatchTokenType("IF_COMMAND");
  IElementType IN_COMMAND = new BatchTokenType("IN_COMMAND");
  IElementType LABEL_MARKER = new BatchTokenType("LABEL_MARKER");
  IElementType MKDIR_ANNOTATION = new BatchTokenType("MKDIR_ANNOTATION");
  IElementType MKDIR_COMMAND = new BatchTokenType("MKDIR_COMMAND");
  IElementType MORE_ANNOTATION = new BatchTokenType("MORE_ANNOTATION");
  IElementType MORE_COMMAND = new BatchTokenType("MORE_COMMAND");
  IElementType NUMERIC = new BatchTokenType("NUMERIC");
  IElementType OPEN_PAREN = new BatchTokenType("OPEN_PAREN");
  IElementType OPERATOR = new BatchTokenType("OPERATOR");
  IElementType PLAINTEXT = new BatchTokenType("PLAINTEXT");
  IElementType REM_DECORATOR = new BatchTokenType("REM_DECORATOR");
  IElementType SETLOCAL_ANNOTATION = new BatchTokenType("SETLOCAL_ANNOTATION");
  IElementType SETLOCAL_COMMAND = new BatchTokenType("SETLOCAL_COMMAND");
  IElementType SETLOCAL_PARAMETER = new BatchTokenType("SETLOCAL_PARAMETER");
  IElementType SET_ANNOTATION = new BatchTokenType("SET_ANNOTATION");
  IElementType SET_COMMAND = new BatchTokenType("SET_COMMAND");
  IElementType SHIFT_ANNOTATION = new BatchTokenType("SHIFT_ANNOTATION");
  IElementType SHIFT_COMMAND = new BatchTokenType("SHIFT_COMMAND");
  IElementType STRING = new BatchTokenType("STRING");
  IElementType TOGGLE = new BatchTokenType("TOGGLE");
  IElementType UNDEFINED_ANNOTATION = new BatchTokenType("UNDEFINED_ANNOTATION");
  IElementType UNDEFINED_COMMAND = new BatchTokenType("UNDEFINED_COMMAND");
  IElementType VARIABLE = new BatchTokenType("VARIABLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATION_REFERENCE) {
        return new BatchAnnotationReferenceImpl(node);
      }
      else if (type == ASSOC_ARGUMENTS) {
        return new BatchAssocArgumentsImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new BatchCallArgumentsImpl(node);
      }
      else if (type == CHDIR_ARGUMENTS) {
        return new BatchChdirArgumentsImpl(node);
      }
      else if (type == COLLECTION) {
        return new BatchCollectionImpl(node);
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
      else if (type == ELSE_ARGUMENTS) {
        return new BatchElseArgumentsImpl(node);
      }
      else if (type == ERROR_IF) {
        return new BatchErrorIfImpl(node);
      }
      else if (type == EXIST_IF) {
        return new BatchExistIfImpl(node);
      }
      else if (type == EXIT_ARGUMENTS) {
        return new BatchExitArgumentsImpl(node);
      }
      else if (type == FOR_ARGUMENTS) {
        return new BatchForArgumentsImpl(node);
      }
      else if (type == IF_ARGUMENTS) {
        return new BatchIfArgumentsImpl(node);
      }
      else if (type == LABEL) {
        return new BatchLabelImpl(node);
      }
      else if (type == MORE_ARGUMENTS) {
        return new BatchMoreArgumentsImpl(node);
      }
      else if (type == OPERATORS) {
        return new BatchOperatorsImpl(node);
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
      else if (type == STANDARD_IF) {
        return new BatchStandardIfImpl(node);
      }
      else if (type == TYPES_) {
        return new BatchTypes_Impl(node);
      }
      else if (type == UNDEFINED_ARGUMENTS) {
        return new BatchUndefinedArgumentsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
