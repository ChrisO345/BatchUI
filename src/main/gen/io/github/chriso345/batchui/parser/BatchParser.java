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
  // variable|label|value_types|set_local|COMMENT|CRLF|misc
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = variable(b, l + 1);
    if (!r) r = label(b, l + 1);
    if (!r) r = value_types(b, l + 1);
    if (!r) r = set_local(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = misc(b, l + 1);
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
  // ANNOTATION|REM_ANNOTATION|COMMAND|CMD_TERMINATOR|SEPARATOR
  public static boolean misc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "misc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MISC, "<misc>");
    r = consumeToken(b, ANNOTATION);
    if (!r) r = consumeToken(b, REM_ANNOTATION);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = consumeToken(b, CMD_TERMINATOR);
    if (!r) r = consumeToken(b, SEPARATOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMAND SET_LOCAL_COMMAND? SET_LOCAL_COMMAND?
  public static boolean set_local(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_local")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND);
    r = r && set_local_1(b, l + 1);
    r = r && set_local_2(b, l + 1);
    exit_section_(b, m, SET_LOCAL, r);
    return r;
  }

  // SET_LOCAL_COMMAND?
  private static boolean set_local_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_local_1")) return false;
    consumeToken(b, SET_LOCAL_COMMAND);
    return true;
  }

  // SET_LOCAL_COMMAND?
  private static boolean set_local_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_local_2")) return false;
    consumeToken(b, SET_LOCAL_COMMAND);
    return true;
  }

  /* ********************************************************** */
  // STRING|NUMERIC|TOGGLE
  public static boolean value_types(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_types")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_TYPES, "<value types>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMERIC);
    if (!r) r = consumeToken(b, TOGGLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMAND CONSTANT
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMAND, CONSTANT);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

}
