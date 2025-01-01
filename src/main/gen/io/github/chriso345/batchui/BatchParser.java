// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui;

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
  // variable|switch|label|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = variable(b, l + 1);
    if (!r) r = switch_$(b, l + 1);
    if (!r) r = label(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // COLON? FUNC_LABEL
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, "<label>", COLON, FUNC_LABEL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL, "<label>");
    r = label_0(b, l + 1);
    r = r && consumeToken(b, FUNC_LABEL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COLON?
  private static boolean label_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label_0")) return false;
    consumeToken(b, COLON);
    return true;
  }

  /* ********************************************************** */
  // ANNOTATION TOGGLE?
  public static boolean switch_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_$")) return false;
    if (!nextTokenIs(b, ANNOTATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANNOTATION);
    r = r && switch_1(b, l + 1);
    exit_section_(b, m, SWITCH, r);
    return r;
  }

  // TOGGLE?
  private static boolean switch_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_1")) return false;
    consumeToken(b, TOGGLE);
    return true;
  }

  /* ********************************************************** */
  // KEY? SEPARATOR VALUE?
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, "<variable>", KEY, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE, "<variable>");
    r = variable_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && variable_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY?
  private static boolean variable_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean variable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

}
