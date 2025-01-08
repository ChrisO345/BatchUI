// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.chriso345.batchui.psi.BatchTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BatchParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return batchFile(b, l + 1);
  }

  /* ********************************************************** */
  // (
  //     REM_DECORATOR COMMENT?
  //     | ECHO_ANNOTATION echo_arguments?
  // ) (COMMAND_TERMINATOR command)?
  public static boolean annotation_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference")) return false;
    if (!nextTokenIs(b, "<annotation reference>", ECHO_ANNOTATION, REM_DECORATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_REFERENCE, "<annotation reference>");
    r = annotation_reference_0(b, l + 1);
    r = r && annotation_reference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // REM_DECORATOR COMMENT?
  //     | ECHO_ANNOTATION echo_arguments?
  private static boolean annotation_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_reference_0_0(b, l + 1);
    if (!r) r = annotation_reference_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // REM_DECORATOR COMMENT?
  private static boolean annotation_reference_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REM_DECORATOR);
    r = r && annotation_reference_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT?
  private static boolean annotation_reference_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_0_1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  // ECHO_ANNOTATION echo_arguments?
  private static boolean annotation_reference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ECHO_ANNOTATION);
    r = r && annotation_reference_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // echo_arguments?
  private static boolean annotation_reference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_1_1")) return false;
    echo_arguments(b, l + 1);
    return true;
  }

  // (COMMAND_TERMINATOR command)?
  private static boolean annotation_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_1")) return false;
    annotation_reference_1_0(b, l + 1);
    return true;
  }

  // COMMAND_TERMINATOR command
  private static boolean annotation_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND_TERMINATOR);
    r = r && command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE (ASSIGNMENT (STRING|NUMERIC)?)?
  public static boolean assoc_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assoc_arguments")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE);
    r = r && assoc_arguments_1(b, l + 1);
    exit_section_(b, m, ASSOC_ARGUMENTS, r);
    return r;
  }

  // (ASSIGNMENT (STRING|NUMERIC)?)?
  private static boolean assoc_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assoc_arguments_1")) return false;
    assoc_arguments_1_0(b, l + 1);
    return true;
  }

  // ASSIGNMENT (STRING|NUMERIC)?
  private static boolean assoc_arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assoc_arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && assoc_arguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING|NUMERIC)?
  private static boolean assoc_arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assoc_arguments_1_0_1")) return false;
    assoc_arguments_1_0_1_0(b, l + 1);
    return true;
  }

  // STRING|NUMERIC
  private static boolean assoc_arguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assoc_arguments_1_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMERIC);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean batchFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "batchFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // label?
  public static boolean call_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments")) return false;
    Marker m = enter_section_(b, l, _NONE_, CALL_ARGUMENTS, "<call arguments>");
    label(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // command_reference | annotation_reference | COMMENT_REFERENCE | PLAINTEXT
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = command_reference(b, l + 1);
    if (!r) r = annotation_reference(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_REFERENCE);
    if (!r) r = consumeToken(b, PLAINTEXT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (
  //     ASSOC_COMMAND assoc_arguments?
  //     | CALL_COMMAND call_arguments?
  //     | ECHO_COMMAND echo_arguments?
  //     | ENDLOCAL_COMMAND
  //     | EXIT_COMMAND exit_arguments?
  //     | GOTO_COMMAND label?
  //     | IF_COMMAND if_arguments?
  //     | MORE_COMMAND more_arguments?
  //     | SET_COMMAND set_arguments?
  //     | SETLOCAL_COMMAND setlocal_arguments?
  //     | SHIFT_COMMAND shift_arguments?
  // ) (COMMAND_TERMINATOR command)?
  public static boolean command_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_REFERENCE, "<command reference>");
    r = command_reference_0(b, l + 1);
    r = r && command_reference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ASSOC_COMMAND assoc_arguments?
  //     | CALL_COMMAND call_arguments?
  //     | ECHO_COMMAND echo_arguments?
  //     | ENDLOCAL_COMMAND
  //     | EXIT_COMMAND exit_arguments?
  //     | GOTO_COMMAND label?
  //     | IF_COMMAND if_arguments?
  //     | MORE_COMMAND more_arguments?
  //     | SET_COMMAND set_arguments?
  //     | SETLOCAL_COMMAND setlocal_arguments?
  //     | SHIFT_COMMAND shift_arguments?
  private static boolean command_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_reference_0_0(b, l + 1);
    if (!r) r = command_reference_0_1(b, l + 1);
    if (!r) r = command_reference_0_2(b, l + 1);
    if (!r) r = consumeToken(b, ENDLOCAL_COMMAND);
    if (!r) r = command_reference_0_4(b, l + 1);
    if (!r) r = command_reference_0_5(b, l + 1);
    if (!r) r = command_reference_0_6(b, l + 1);
    if (!r) r = command_reference_0_7(b, l + 1);
    if (!r) r = command_reference_0_8(b, l + 1);
    if (!r) r = command_reference_0_9(b, l + 1);
    if (!r) r = command_reference_0_10(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASSOC_COMMAND assoc_arguments?
  private static boolean command_reference_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSOC_COMMAND);
    r = r && command_reference_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assoc_arguments?
  private static boolean command_reference_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_0_1")) return false;
    assoc_arguments(b, l + 1);
    return true;
  }

  // CALL_COMMAND call_arguments?
  private static boolean command_reference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL_COMMAND);
    r = r && command_reference_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_arguments?
  private static boolean command_reference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_1_1")) return false;
    call_arguments(b, l + 1);
    return true;
  }

  // ECHO_COMMAND echo_arguments?
  private static boolean command_reference_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ECHO_COMMAND);
    r = r && command_reference_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // echo_arguments?
  private static boolean command_reference_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_2_1")) return false;
    echo_arguments(b, l + 1);
    return true;
  }

  // EXIT_COMMAND exit_arguments?
  private static boolean command_reference_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIT_COMMAND);
    r = r && command_reference_0_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exit_arguments?
  private static boolean command_reference_0_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_4_1")) return false;
    exit_arguments(b, l + 1);
    return true;
  }

  // GOTO_COMMAND label?
  private static boolean command_reference_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOTO_COMMAND);
    r = r && command_reference_0_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label?
  private static boolean command_reference_0_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_5_1")) return false;
    label(b, l + 1);
    return true;
  }

  // IF_COMMAND if_arguments?
  private static boolean command_reference_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_COMMAND);
    r = r && command_reference_0_6_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_arguments?
  private static boolean command_reference_0_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_6_1")) return false;
    if_arguments(b, l + 1);
    return true;
  }

  // MORE_COMMAND more_arguments?
  private static boolean command_reference_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MORE_COMMAND);
    r = r && command_reference_0_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // more_arguments?
  private static boolean command_reference_0_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_7_1")) return false;
    more_arguments(b, l + 1);
    return true;
  }

  // SET_COMMAND set_arguments?
  private static boolean command_reference_0_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET_COMMAND);
    r = r && command_reference_0_8_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_arguments?
  private static boolean command_reference_0_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_8_1")) return false;
    set_arguments(b, l + 1);
    return true;
  }

  // SETLOCAL_COMMAND setlocal_arguments?
  private static boolean command_reference_0_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETLOCAL_COMMAND);
    r = r && command_reference_0_9_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // setlocal_arguments?
  private static boolean command_reference_0_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_9_1")) return false;
    setlocal_arguments(b, l + 1);
    return true;
  }

  // SHIFT_COMMAND shift_arguments?
  private static boolean command_reference_0_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHIFT_COMMAND);
    r = r && command_reference_0_10_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shift_arguments?
  private static boolean command_reference_0_10_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_10_1")) return false;
    shift_arguments(b, l + 1);
    return true;
  }

  // (COMMAND_TERMINATOR command)?
  private static boolean command_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_1")) return false;
    command_reference_1_0(b, l + 1);
    return true;
  }

  // COMMAND_TERMINATOR command
  private static boolean command_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND_TERMINATOR);
    r = r && command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (TOGGLE | (STRING|PLAINTEXT)*)?
  public static boolean echo_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments")) return false;
    Marker m = enter_section_(b, l, _NONE_, ECHO_ARGUMENTS, "<echo arguments>");
    echo_arguments_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // TOGGLE | (STRING|PLAINTEXT)*
  private static boolean echo_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TOGGLE);
    if (!r) r = echo_arguments_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING|PLAINTEXT)*
  private static boolean echo_arguments_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!echo_arguments_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "echo_arguments_0_1", c)) break;
    }
    return true;
  }

  // STRING|PLAINTEXT
  private static boolean echo_arguments_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, PLAINTEXT);
    return r;
  }

  /* ********************************************************** */
  // ERRORLEVEL_TOKEN NUMERIC command
  public static boolean error_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_if")) return false;
    if (!nextTokenIs(b, ERRORLEVEL_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ERRORLEVEL_TOKEN, NUMERIC);
    r = r && command(b, l + 1);
    exit_section_(b, m, ERROR_IF, r);
    return r;
  }

  /* ********************************************************** */
  // EXIST_TOKEN STRING command
  public static boolean exist_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exist_if")) return false;
    if (!nextTokenIs(b, EXIST_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EXIST_TOKEN, STRING);
    r = r && command(b, l + 1);
    exit_section_(b, m, EXIST_IF, r);
    return r;
  }

  /* ********************************************************** */
  // EXTENSION NUMERIC?
  public static boolean exit_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_arguments")) return false;
    if (!nextTokenIs(b, EXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENSION);
    r = r && exit_arguments_1(b, l + 1);
    exit_section_(b, m, EXIT_ARGUMENTS, r);
    return r;
  }

  // NUMERIC?
  private static boolean exit_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_arguments_1")) return false;
    consumeToken(b, NUMERIC);
    return true;
  }

  /* ********************************************************** */
  // COMPARISON_OPERATOR? (error_if | standard_if | exist_if)
  public static boolean if_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_ARGUMENTS, "<if arguments>");
    r = if_arguments_0(b, l + 1);
    r = r && if_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMPARISON_OPERATOR?
  private static boolean if_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_arguments_0")) return false;
    consumeToken(b, COMPARISON_OPERATOR);
    return true;
  }

  // error_if | standard_if | exist_if
  private static boolean if_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_arguments_1")) return false;
    boolean r;
    r = error_if(b, l + 1);
    if (!r) r = standard_if(b, l + 1);
    if (!r) r = exist_if(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // prefix          // ECHO, SET, etc
  //     | label
  //     | COMMENT        // REM, ::
  //     | CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = prefix(b, l + 1);
    if (!r) r = label(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // LABEL_MARKER? FUNC_LABEL
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, "<label>", FUNC_LABEL, LABEL_MARKER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL, "<label>");
    r = label_0(b, l + 1);
    r = r && consumeToken(b, FUNC_LABEL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LABEL_MARKER?
  private static boolean label_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label_0")) return false;
    consumeToken(b, LABEL_MARKER);
    return true;
  }

  /* ********************************************************** */
  // (EXTENSION | PLAINTEXT | DISK_DRIVE) more_arguments?
  public static boolean more_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "more_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, MORE_ARGUMENTS, "<more arguments>");
    r = more_arguments_0(b, l + 1);
    r = r && more_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXTENSION | PLAINTEXT | DISK_DRIVE
  private static boolean more_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "more_arguments_0")) return false;
    boolean r;
    r = consumeToken(b, EXTENSION);
    if (!r) r = consumeToken(b, PLAINTEXT);
    if (!r) r = consumeToken(b, DISK_DRIVE);
    return r;
  }

  // more_arguments?
  private static boolean more_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "more_arguments_1")) return false;
    more_arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COMPARISON_OPERATOR | OPERATOR
  public static boolean operators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operators")) return false;
    if (!nextTokenIs(b, "<operators>", COMPARISON_OPERATOR, OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATORS, "<operators>");
    r = consumeToken(b, COMPARISON_OPERATOR);
    if (!r) r = consumeToken(b, OPERATOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DECORATOR? command
  public static boolean prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX, "<prefix>");
    r = prefix_0(b, l + 1);
    r = r && command(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DECORATOR?
  private static boolean prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_0")) return false;
    consumeToken(b, DECORATOR);
    return true;
  }

  /* ********************************************************** */
  // EXTENSION? VARIABLE ASSIGNMENT (STRING | types_)?
  public static boolean set_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_arguments")) return false;
    if (!nextTokenIs(b, "<set arguments>", EXTENSION, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_ARGUMENTS, "<set arguments>");
    r = set_arguments_0(b, l + 1);
    r = r && consumeTokens(b, 0, VARIABLE, ASSIGNMENT);
    r = r && set_arguments_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXTENSION?
  private static boolean set_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_arguments_0")) return false;
    consumeToken(b, EXTENSION);
    return true;
  }

  // (STRING | types_)?
  private static boolean set_arguments_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_arguments_3")) return false;
    set_arguments_3_0(b, l + 1);
    return true;
  }

  // STRING | types_
  private static boolean set_arguments_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_arguments_3_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = types_(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SETLOCAL_PARAMETER SETLOCAL_PARAMETER?
  public static boolean setlocal_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setlocal_arguments")) return false;
    if (!nextTokenIs(b, SETLOCAL_PARAMETER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETLOCAL_PARAMETER);
    r = r && setlocal_arguments_1(b, l + 1);
    exit_section_(b, m, SETLOCAL_ARGUMENTS, r);
    return r;
  }

  // SETLOCAL_PARAMETER?
  private static boolean setlocal_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setlocal_arguments_1")) return false;
    consumeToken(b, SETLOCAL_PARAMETER);
    return true;
  }

  /* ********************************************************** */
  // EXTENSION
  public static boolean shift_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_arguments")) return false;
    if (!nextTokenIs(b, EXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENSION);
    exit_section_(b, m, SHIFT_ARGUMENTS, r);
    return r;
  }

  /* ********************************************************** */
  // (STRING | VARIABLE) COMPARISON_OPERATOR (STRING | VARIABLE) command
  public static boolean standard_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if")) return false;
    if (!nextTokenIs(b, "<standard if>", STRING, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STANDARD_IF, "<standard if>");
    r = standard_if_0(b, l + 1);
    r = r && consumeToken(b, COMPARISON_OPERATOR);
    r = r && standard_if_2(b, l + 1);
    r = r && command(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING | VARIABLE
  private static boolean standard_if_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, VARIABLE);
    return r;
  }

  // STRING | VARIABLE
  private static boolean standard_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if_2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, VARIABLE);
    return r;
  }

  /* ********************************************************** */
  // STRING | NUMERIC | PLAINTEXT | DISK_DRIVE
  public static boolean types_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "types_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPES_, "<types>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMERIC);
    if (!r) r = consumeToken(b, PLAINTEXT);
    if (!r) r = consumeToken(b, DISK_DRIVE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
