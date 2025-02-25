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
  //     ASSOC_ANNOTATION assoc_arguments?
  //     | ATTRIB_ANNOTATION attrib_arguments?
  //     | BREAK_ANNOTATION TOGGLE?
  //     | CALL_ANNOTATION call_arguments?
  //     | CHDIR_ANNOTATION chdir_arguments?
  //     | CLS_ANNOTATION
  //     | COLOR_ANNOTATION color_arguments?
  //     | DATE_ANNOTATION date_arguments?
  //     | ECHO_ANNOTATION echo_arguments?
  //     | ELSE_ANNOTATION else_arguments?
  //     | ENDLOCAL_ANNOTATION
  //     | EXIT_ANNOTATION exit_arguments?
  //     | FOR_ANNOTATION for_arguments?
  //     | GOTO_ANNOTATION label?
  //     | IF_ANNOTATION if_arguments?
  //     | MKDIR_ANNOTATION types_
  //     | MORE_ANNOTATION more_arguments?
  //     | SET_ANNOTATION set_arguments?
  //     | SETLOCAL_ANNOTATION setlocal_arguments?
  //     | SHIFT_ANNOTATION shift_arguments?
  //     | UNDEFINED_ANNOTATION undefined_arguments?
  // ) (COMMAND_TERMINATOR command)?
  public static boolean annotation_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_REFERENCE, "<annotation reference>");
    r = annotation_reference_0(b, l + 1);
    r = r && annotation_reference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ASSOC_ANNOTATION assoc_arguments?
  //     | ATTRIB_ANNOTATION attrib_arguments?
  //     | BREAK_ANNOTATION TOGGLE?
  //     | CALL_ANNOTATION call_arguments?
  //     | CHDIR_ANNOTATION chdir_arguments?
  //     | CLS_ANNOTATION
  //     | COLOR_ANNOTATION color_arguments?
  //     | DATE_ANNOTATION date_arguments?
  //     | ECHO_ANNOTATION echo_arguments?
  //     | ELSE_ANNOTATION else_arguments?
  //     | ENDLOCAL_ANNOTATION
  //     | EXIT_ANNOTATION exit_arguments?
  //     | FOR_ANNOTATION for_arguments?
  //     | GOTO_ANNOTATION label?
  //     | IF_ANNOTATION if_arguments?
  //     | MKDIR_ANNOTATION types_
  //     | MORE_ANNOTATION more_arguments?
  //     | SET_ANNOTATION set_arguments?
  //     | SETLOCAL_ANNOTATION setlocal_arguments?
  //     | SHIFT_ANNOTATION shift_arguments?
  //     | UNDEFINED_ANNOTATION undefined_arguments?
  private static boolean annotation_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation_reference_0_0(b, l + 1);
    if (!r) r = annotation_reference_0_1(b, l + 1);
    if (!r) r = annotation_reference_0_2(b, l + 1);
    if (!r) r = annotation_reference_0_3(b, l + 1);
    if (!r) r = annotation_reference_0_4(b, l + 1);
    if (!r) r = consumeToken(b, CLS_ANNOTATION);
    if (!r) r = annotation_reference_0_6(b, l + 1);
    if (!r) r = annotation_reference_0_7(b, l + 1);
    if (!r) r = annotation_reference_0_8(b, l + 1);
    if (!r) r = annotation_reference_0_9(b, l + 1);
    if (!r) r = consumeToken(b, ENDLOCAL_ANNOTATION);
    if (!r) r = annotation_reference_0_11(b, l + 1);
    if (!r) r = annotation_reference_0_12(b, l + 1);
    if (!r) r = annotation_reference_0_13(b, l + 1);
    if (!r) r = annotation_reference_0_14(b, l + 1);
    if (!r) r = annotation_reference_0_15(b, l + 1);
    if (!r) r = annotation_reference_0_16(b, l + 1);
    if (!r) r = annotation_reference_0_17(b, l + 1);
    if (!r) r = annotation_reference_0_18(b, l + 1);
    if (!r) r = annotation_reference_0_19(b, l + 1);
    if (!r) r = annotation_reference_0_20(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASSOC_ANNOTATION assoc_arguments?
  private static boolean annotation_reference_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSOC_ANNOTATION);
    r = r && annotation_reference_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assoc_arguments?
  private static boolean annotation_reference_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_0_1")) return false;
    assoc_arguments(b, l + 1);
    return true;
  }

  // ATTRIB_ANNOTATION attrib_arguments?
  private static boolean annotation_reference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATTRIB_ANNOTATION);
    r = r && annotation_reference_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attrib_arguments?
  private static boolean annotation_reference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_1_1")) return false;
    attrib_arguments(b, l + 1);
    return true;
  }

  // BREAK_ANNOTATION TOGGLE?
  private static boolean annotation_reference_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK_ANNOTATION);
    r = r && annotation_reference_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TOGGLE?
  private static boolean annotation_reference_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_2_1")) return false;
    consumeToken(b, TOGGLE);
    return true;
  }

  // CALL_ANNOTATION call_arguments?
  private static boolean annotation_reference_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL_ANNOTATION);
    r = r && annotation_reference_0_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_arguments?
  private static boolean annotation_reference_0_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_3_1")) return false;
    call_arguments(b, l + 1);
    return true;
  }

  // CHDIR_ANNOTATION chdir_arguments?
  private static boolean annotation_reference_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHDIR_ANNOTATION);
    r = r && annotation_reference_0_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // chdir_arguments?
  private static boolean annotation_reference_0_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_4_1")) return false;
    chdir_arguments(b, l + 1);
    return true;
  }

  // COLOR_ANNOTATION color_arguments?
  private static boolean annotation_reference_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLOR_ANNOTATION);
    r = r && annotation_reference_0_6_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // color_arguments?
  private static boolean annotation_reference_0_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_6_1")) return false;
    color_arguments(b, l + 1);
    return true;
  }

  // DATE_ANNOTATION date_arguments?
  private static boolean annotation_reference_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATE_ANNOTATION);
    r = r && annotation_reference_0_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // date_arguments?
  private static boolean annotation_reference_0_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_7_1")) return false;
    date_arguments(b, l + 1);
    return true;
  }

  // ECHO_ANNOTATION echo_arguments?
  private static boolean annotation_reference_0_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ECHO_ANNOTATION);
    r = r && annotation_reference_0_8_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // echo_arguments?
  private static boolean annotation_reference_0_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_8_1")) return false;
    echo_arguments(b, l + 1);
    return true;
  }

  // ELSE_ANNOTATION else_arguments?
  private static boolean annotation_reference_0_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_ANNOTATION);
    r = r && annotation_reference_0_9_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // else_arguments?
  private static boolean annotation_reference_0_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_9_1")) return false;
    else_arguments(b, l + 1);
    return true;
  }

  // EXIT_ANNOTATION exit_arguments?
  private static boolean annotation_reference_0_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIT_ANNOTATION);
    r = r && annotation_reference_0_11_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exit_arguments?
  private static boolean annotation_reference_0_11_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_11_1")) return false;
    exit_arguments(b, l + 1);
    return true;
  }

  // FOR_ANNOTATION for_arguments?
  private static boolean annotation_reference_0_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_ANNOTATION);
    r = r && annotation_reference_0_12_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // for_arguments?
  private static boolean annotation_reference_0_12_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_12_1")) return false;
    for_arguments(b, l + 1);
    return true;
  }

  // GOTO_ANNOTATION label?
  private static boolean annotation_reference_0_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOTO_ANNOTATION);
    r = r && annotation_reference_0_13_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label?
  private static boolean annotation_reference_0_13_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_13_1")) return false;
    label(b, l + 1);
    return true;
  }

  // IF_ANNOTATION if_arguments?
  private static boolean annotation_reference_0_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_ANNOTATION);
    r = r && annotation_reference_0_14_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_arguments?
  private static boolean annotation_reference_0_14_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_14_1")) return false;
    if_arguments(b, l + 1);
    return true;
  }

  // MKDIR_ANNOTATION types_
  private static boolean annotation_reference_0_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MKDIR_ANNOTATION);
    r = r && types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MORE_ANNOTATION more_arguments?
  private static boolean annotation_reference_0_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MORE_ANNOTATION);
    r = r && annotation_reference_0_16_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // more_arguments?
  private static boolean annotation_reference_0_16_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_16_1")) return false;
    more_arguments(b, l + 1);
    return true;
  }

  // SET_ANNOTATION set_arguments?
  private static boolean annotation_reference_0_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_17")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET_ANNOTATION);
    r = r && annotation_reference_0_17_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_arguments?
  private static boolean annotation_reference_0_17_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_17_1")) return false;
    set_arguments(b, l + 1);
    return true;
  }

  // SETLOCAL_ANNOTATION setlocal_arguments?
  private static boolean annotation_reference_0_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETLOCAL_ANNOTATION);
    r = r && annotation_reference_0_18_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // setlocal_arguments?
  private static boolean annotation_reference_0_18_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_18_1")) return false;
    setlocal_arguments(b, l + 1);
    return true;
  }

  // SHIFT_ANNOTATION shift_arguments?
  private static boolean annotation_reference_0_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_19")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHIFT_ANNOTATION);
    r = r && annotation_reference_0_19_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shift_arguments?
  private static boolean annotation_reference_0_19_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_19_1")) return false;
    shift_arguments(b, l + 1);
    return true;
  }

  // UNDEFINED_ANNOTATION undefined_arguments?
  private static boolean annotation_reference_0_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDEFINED_ANNOTATION);
    r = r && annotation_reference_0_20_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // undefined_arguments?
  private static boolean annotation_reference_0_20_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_reference_0_20_1")) return false;
    undefined_arguments(b, l + 1);
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
  // (types_ | EXTENSION) attrib_arguments?
  public static boolean attrib_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrib_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ATTRIB_ARGUMENTS, "<attrib arguments>");
    r = attrib_arguments_0(b, l + 1);
    r = r && attrib_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // types_ | EXTENSION
  private static boolean attrib_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrib_arguments_0")) return false;
    boolean r;
    r = types_(b, l + 1);
    if (!r) r = consumeToken(b, EXTENSION);
    return r;
  }

  // attrib_arguments?
  private static boolean attrib_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrib_arguments_1")) return false;
    attrib_arguments(b, l + 1);
    return true;
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
  // EXTENSION? (DISK_DRIVE | PLAINTEXT | VARIABLE)
  public static boolean chdir_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chdir_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHDIR_ARGUMENTS, "<chdir arguments>");
    r = chdir_arguments_0(b, l + 1);
    r = r && chdir_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXTENSION?
  private static boolean chdir_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chdir_arguments_0")) return false;
    consumeToken(b, EXTENSION);
    return true;
  }

  // DISK_DRIVE | PLAINTEXT | VARIABLE
  private static boolean chdir_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chdir_arguments_1")) return false;
    boolean r;
    r = consumeToken(b, DISK_DRIVE);
    if (!r) r = consumeToken(b, PLAINTEXT);
    if (!r) r = consumeToken(b, VARIABLE);
    return r;
  }

  /* ********************************************************** */
  // OPEN_PAREN recurse_types_ CLOSE_PAREN
  public static boolean collection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection")) return false;
    if (!nextTokenIs(b, OPEN_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_types_(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, COLLECTION, r);
    return r;
  }

  /* ********************************************************** */
  // NUMERIC
  public static boolean color_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "color_arguments")) return false;
    if (!nextTokenIs(b, NUMERIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMERIC);
    exit_section_(b, m, COLOR_ARGUMENTS, r);
    return r;
  }

  /* ********************************************************** */
  // command_reference | annotation_reference | COMMENT_REFERENCE | REM_DECORATOR COMMENT? | PLAINTEXT
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = command_reference(b, l + 1);
    if (!r) r = annotation_reference(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_REFERENCE);
    if (!r) r = command_3(b, l + 1);
    if (!r) r = consumeToken(b, PLAINTEXT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // REM_DECORATOR COMMENT?
  private static boolean command_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REM_DECORATOR);
    r = r && command_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT?
  private static boolean command_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_3_1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // (
  //     ASSOC_COMMAND assoc_arguments?
  //     | ATTRIB_COMMAND attrib_arguments?
  //     | BREAK_COMMAND TOGGLE?
  //     | CALL_COMMAND call_arguments?
  //     | CHDIR_COMMAND chdir_arguments?
  //     | COLOR_COMMAND color_arguments?
  //     | CLS_COMMAND
  //     | DATE_COMMAND date_arguments?
  //     | ECHO_COMMAND echo_arguments?
  //     | ELSE_COMMAND else_arguments?
  //     | ENDLOCAL_COMMAND
  //     | EXIT_COMMAND exit_arguments?
  //     | FOR_COMMAND for_arguments?
  //     | GOTO_COMMAND label?
  //     | IF_COMMAND if_arguments?
  //     | MKDIR_COMMAND types_
  //     | MORE_COMMAND more_arguments?
  //     | SET_COMMAND set_arguments?
  //     | SETLOCAL_COMMAND setlocal_arguments?
  //     | SHIFT_COMMAND shift_arguments?
  //     | UNDEFINED_COMMAND undefined_arguments?
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
  //     | ATTRIB_COMMAND attrib_arguments?
  //     | BREAK_COMMAND TOGGLE?
  //     | CALL_COMMAND call_arguments?
  //     | CHDIR_COMMAND chdir_arguments?
  //     | COLOR_COMMAND color_arguments?
  //     | CLS_COMMAND
  //     | DATE_COMMAND date_arguments?
  //     | ECHO_COMMAND echo_arguments?
  //     | ELSE_COMMAND else_arguments?
  //     | ENDLOCAL_COMMAND
  //     | EXIT_COMMAND exit_arguments?
  //     | FOR_COMMAND for_arguments?
  //     | GOTO_COMMAND label?
  //     | IF_COMMAND if_arguments?
  //     | MKDIR_COMMAND types_
  //     | MORE_COMMAND more_arguments?
  //     | SET_COMMAND set_arguments?
  //     | SETLOCAL_COMMAND setlocal_arguments?
  //     | SHIFT_COMMAND shift_arguments?
  //     | UNDEFINED_COMMAND undefined_arguments?
  private static boolean command_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command_reference_0_0(b, l + 1);
    if (!r) r = command_reference_0_1(b, l + 1);
    if (!r) r = command_reference_0_2(b, l + 1);
    if (!r) r = command_reference_0_3(b, l + 1);
    if (!r) r = command_reference_0_4(b, l + 1);
    if (!r) r = command_reference_0_5(b, l + 1);
    if (!r) r = consumeToken(b, CLS_COMMAND);
    if (!r) r = command_reference_0_7(b, l + 1);
    if (!r) r = command_reference_0_8(b, l + 1);
    if (!r) r = command_reference_0_9(b, l + 1);
    if (!r) r = consumeToken(b, ENDLOCAL_COMMAND);
    if (!r) r = command_reference_0_11(b, l + 1);
    if (!r) r = command_reference_0_12(b, l + 1);
    if (!r) r = command_reference_0_13(b, l + 1);
    if (!r) r = command_reference_0_14(b, l + 1);
    if (!r) r = command_reference_0_15(b, l + 1);
    if (!r) r = command_reference_0_16(b, l + 1);
    if (!r) r = command_reference_0_17(b, l + 1);
    if (!r) r = command_reference_0_18(b, l + 1);
    if (!r) r = command_reference_0_19(b, l + 1);
    if (!r) r = command_reference_0_20(b, l + 1);
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

  // ATTRIB_COMMAND attrib_arguments?
  private static boolean command_reference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATTRIB_COMMAND);
    r = r && command_reference_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attrib_arguments?
  private static boolean command_reference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_1_1")) return false;
    attrib_arguments(b, l + 1);
    return true;
  }

  // BREAK_COMMAND TOGGLE?
  private static boolean command_reference_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK_COMMAND);
    r = r && command_reference_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TOGGLE?
  private static boolean command_reference_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_2_1")) return false;
    consumeToken(b, TOGGLE);
    return true;
  }

  // CALL_COMMAND call_arguments?
  private static boolean command_reference_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL_COMMAND);
    r = r && command_reference_0_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // call_arguments?
  private static boolean command_reference_0_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_3_1")) return false;
    call_arguments(b, l + 1);
    return true;
  }

  // CHDIR_COMMAND chdir_arguments?
  private static boolean command_reference_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHDIR_COMMAND);
    r = r && command_reference_0_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // chdir_arguments?
  private static boolean command_reference_0_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_4_1")) return false;
    chdir_arguments(b, l + 1);
    return true;
  }

  // COLOR_COMMAND color_arguments?
  private static boolean command_reference_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLOR_COMMAND);
    r = r && command_reference_0_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // color_arguments?
  private static boolean command_reference_0_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_5_1")) return false;
    color_arguments(b, l + 1);
    return true;
  }

  // DATE_COMMAND date_arguments?
  private static boolean command_reference_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATE_COMMAND);
    r = r && command_reference_0_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // date_arguments?
  private static boolean command_reference_0_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_7_1")) return false;
    date_arguments(b, l + 1);
    return true;
  }

  // ECHO_COMMAND echo_arguments?
  private static boolean command_reference_0_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ECHO_COMMAND);
    r = r && command_reference_0_8_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // echo_arguments?
  private static boolean command_reference_0_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_8_1")) return false;
    echo_arguments(b, l + 1);
    return true;
  }

  // ELSE_COMMAND else_arguments?
  private static boolean command_reference_0_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_COMMAND);
    r = r && command_reference_0_9_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // else_arguments?
  private static boolean command_reference_0_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_9_1")) return false;
    else_arguments(b, l + 1);
    return true;
  }

  // EXIT_COMMAND exit_arguments?
  private static boolean command_reference_0_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIT_COMMAND);
    r = r && command_reference_0_11_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exit_arguments?
  private static boolean command_reference_0_11_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_11_1")) return false;
    exit_arguments(b, l + 1);
    return true;
  }

  // FOR_COMMAND for_arguments?
  private static boolean command_reference_0_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_COMMAND);
    r = r && command_reference_0_12_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // for_arguments?
  private static boolean command_reference_0_12_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_12_1")) return false;
    for_arguments(b, l + 1);
    return true;
  }

  // GOTO_COMMAND label?
  private static boolean command_reference_0_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOTO_COMMAND);
    r = r && command_reference_0_13_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label?
  private static boolean command_reference_0_13_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_13_1")) return false;
    label(b, l + 1);
    return true;
  }

  // IF_COMMAND if_arguments?
  private static boolean command_reference_0_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_COMMAND);
    r = r && command_reference_0_14_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if_arguments?
  private static boolean command_reference_0_14_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_14_1")) return false;
    if_arguments(b, l + 1);
    return true;
  }

  // MKDIR_COMMAND types_
  private static boolean command_reference_0_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MKDIR_COMMAND);
    r = r && types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MORE_COMMAND more_arguments?
  private static boolean command_reference_0_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MORE_COMMAND);
    r = r && command_reference_0_16_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // more_arguments?
  private static boolean command_reference_0_16_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_16_1")) return false;
    more_arguments(b, l + 1);
    return true;
  }

  // SET_COMMAND set_arguments?
  private static boolean command_reference_0_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_17")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET_COMMAND);
    r = r && command_reference_0_17_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set_arguments?
  private static boolean command_reference_0_17_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_17_1")) return false;
    set_arguments(b, l + 1);
    return true;
  }

  // SETLOCAL_COMMAND setlocal_arguments?
  private static boolean command_reference_0_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETLOCAL_COMMAND);
    r = r && command_reference_0_18_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // setlocal_arguments?
  private static boolean command_reference_0_18_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_18_1")) return false;
    setlocal_arguments(b, l + 1);
    return true;
  }

  // SHIFT_COMMAND shift_arguments?
  private static boolean command_reference_0_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_19")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHIFT_COMMAND);
    r = r && command_reference_0_19_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shift_arguments?
  private static boolean command_reference_0_19_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_19_1")) return false;
    shift_arguments(b, l + 1);
    return true;
  }

  // UNDEFINED_COMMAND undefined_arguments?
  private static boolean command_reference_0_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDEFINED_COMMAND);
    r = r && command_reference_0_20_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // undefined_arguments?
  private static boolean command_reference_0_20_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_reference_0_20_1")) return false;
    undefined_arguments(b, l + 1);
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
  // EXTENSION? NUMERIC?
  public static boolean date_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATE_ARGUMENTS, "<date arguments>");
    r = date_arguments_0(b, l + 1);
    r = r && date_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXTENSION?
  private static boolean date_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arguments_0")) return false;
    consumeToken(b, EXTENSION);
    return true;
  }

  // NUMERIC?
  private static boolean date_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arguments_1")) return false;
    consumeToken(b, NUMERIC);
    return true;
  }

  /* ********************************************************** */
  // (TOGGLE | (types_)*)?
  public static boolean echo_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments")) return false;
    Marker m = enter_section_(b, l, _NONE_, ECHO_ARGUMENTS, "<echo arguments>");
    echo_arguments_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // TOGGLE | (types_)*
  private static boolean echo_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TOGGLE);
    if (!r) r = echo_arguments_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (types_)*
  private static boolean echo_arguments_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!echo_arguments_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "echo_arguments_0_1", c)) break;
    }
    return true;
  }

  // (types_)
  private static boolean echo_arguments_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_arguments_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // command | (OPEN_PAREN recurse_item CLOSE_PAREN)
  public static boolean else_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSE_ARGUMENTS, "<else arguments>");
    r = command(b, l + 1);
    if (!r) r = else_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPEN_PAREN recurse_item CLOSE_PAREN
  private static boolean else_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_arguments_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_item(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ERRORLEVEL_TOKEN NUMERIC (command | (OPEN_PAREN recurse_item CLOSE_PAREN))
  public static boolean error_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_if")) return false;
    if (!nextTokenIs(b, ERRORLEVEL_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ERRORLEVEL_TOKEN, NUMERIC);
    r = r && error_if_2(b, l + 1);
    exit_section_(b, m, ERROR_IF, r);
    return r;
  }

  // command | (OPEN_PAREN recurse_item CLOSE_PAREN)
  private static boolean error_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_if_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    if (!r) r = error_if_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPEN_PAREN recurse_item CLOSE_PAREN
  private static boolean error_if_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_if_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_item(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXIST_TOKEN (STRING | PLAINTEXT | VARIABLE) (command | (OPEN_PAREN recurse_item CLOSE_PAREN))
  public static boolean exist_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exist_if")) return false;
    if (!nextTokenIs(b, EXIST_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIST_TOKEN);
    r = r && exist_if_1(b, l + 1);
    r = r && exist_if_2(b, l + 1);
    exit_section_(b, m, EXIST_IF, r);
    return r;
  }

  // STRING | PLAINTEXT | VARIABLE
  private static boolean exist_if_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exist_if_1")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, PLAINTEXT);
    if (!r) r = consumeToken(b, VARIABLE);
    return r;
  }

  // command | (OPEN_PAREN recurse_item CLOSE_PAREN)
  private static boolean exist_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exist_if_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    if (!r) r = exist_if_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPEN_PAREN recurse_item CLOSE_PAREN
  private static boolean exist_if_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exist_if_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_item(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
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
  // (EXTENSION (for_params | STRING))? FOR_VARIABLE IN_COMMAND collection DO_COMMAND (command | (OPEN_PAREN recurse_item CLOSE_PAREN))
  public static boolean for_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_arguments")) return false;
    if (!nextTokenIs(b, "<for arguments>", EXTENSION, FOR_VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_ARGUMENTS, "<for arguments>");
    r = for_arguments_0(b, l + 1);
    r = r && consumeTokens(b, 0, FOR_VARIABLE, IN_COMMAND);
    r = r && collection(b, l + 1);
    r = r && consumeToken(b, DO_COMMAND);
    r = r && for_arguments_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EXTENSION (for_params | STRING))?
  private static boolean for_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_arguments_0")) return false;
    for_arguments_0_0(b, l + 1);
    return true;
  }

  // EXTENSION (for_params | STRING)
  private static boolean for_arguments_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_arguments_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENSION);
    r = r && for_arguments_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // for_params | STRING
  private static boolean for_arguments_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_arguments_0_0_1")) return false;
    boolean r;
    r = for_params(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  // command | (OPEN_PAREN recurse_item CLOSE_PAREN)
  private static boolean for_arguments_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_arguments_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    if (!r) r = for_arguments_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPEN_PAREN recurse_item CLOSE_PAREN
  private static boolean for_arguments_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_arguments_5_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_item(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLAINTEXT for_params?
  static boolean for_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_params")) return false;
    if (!nextTokenIs(b, PLAINTEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAINTEXT);
    r = r && for_params_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // for_params?
  private static boolean for_params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_params_1")) return false;
    for_params(b, l + 1);
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
  //     | OPEN_PAREN recurse_item CLOSE_PAREN
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix(b, l + 1);
    if (!r) r = label(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = item__4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPEN_PAREN recurse_item CLOSE_PAREN
  private static boolean item__4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_item(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
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
  // item_ recurse_item?
  static boolean recurse_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recurse_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_(b, l + 1);
    r = r && recurse_item_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // recurse_item?
  private static boolean recurse_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recurse_item_1")) return false;
    recurse_item(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // types_ recurse_types_?
  static boolean recurse_types_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recurse_types_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    r = r && recurse_types__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // recurse_types_?
  private static boolean recurse_types__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recurse_types__1")) return false;
    recurse_types_(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EXTENSION? VARIABLE ASSIGNMENT (recurse_types_)?
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

  // (recurse_types_)?
  private static boolean set_arguments_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_arguments_3")) return false;
    set_arguments_3_0(b, l + 1);
    return true;
  }

  // (recurse_types_)
  private static boolean set_arguments_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_arguments_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recurse_types_(b, l + 1);
    exit_section_(b, m, null, r);
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
  // (types_ | VARIABLE) operators (types_ | VARIABLE) (command | (OPEN_PAREN recurse_item CLOSE_PAREN))
  public static boolean standard_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STANDARD_IF, "<standard if>");
    r = standard_if_0(b, l + 1);
    r = r && operators(b, l + 1);
    r = r && standard_if_2(b, l + 1);
    r = r && standard_if_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // types_ | VARIABLE
  private static boolean standard_if_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if_0")) return false;
    boolean r;
    r = types_(b, l + 1);
    if (!r) r = consumeToken(b, VARIABLE);
    return r;
  }

  // types_ | VARIABLE
  private static boolean standard_if_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if_2")) return false;
    boolean r;
    r = types_(b, l + 1);
    if (!r) r = consumeToken(b, VARIABLE);
    return r;
  }

  // command | (OPEN_PAREN recurse_item CLOSE_PAREN)
  private static boolean standard_if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    if (!r) r = standard_if_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPEN_PAREN recurse_item CLOSE_PAREN
  private static boolean standard_if_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_if_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && recurse_item(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | NUMERIC | PLAINTEXT | DISK_DRIVE | VARIABLE | ARG_LITERAL | FOR_VARIABLE
  public static boolean types_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "types_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPES_, "<types>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMERIC);
    if (!r) r = consumeToken(b, PLAINTEXT);
    if (!r) r = consumeToken(b, DISK_DRIVE);
    if (!r) r = consumeToken(b, VARIABLE);
    if (!r) r = consumeToken(b, ARG_LITERAL);
    if (!r) r = consumeToken(b, FOR_VARIABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (EXTENSION | PLAINTEXT | DISK_DRIVE) undefined_arguments?
  public static boolean undefined_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "undefined_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, UNDEFINED_ARGUMENTS, "<undefined arguments>");
    r = undefined_arguments_0(b, l + 1);
    r = r && undefined_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXTENSION | PLAINTEXT | DISK_DRIVE
  private static boolean undefined_arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "undefined_arguments_0")) return false;
    boolean r;
    r = consumeToken(b, EXTENSION);
    if (!r) r = consumeToken(b, PLAINTEXT);
    if (!r) r = consumeToken(b, DISK_DRIVE);
    return r;
  }

  // undefined_arguments?
  private static boolean undefined_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "undefined_arguments_1")) return false;
    undefined_arguments(b, l + 1);
    return true;
  }

}
