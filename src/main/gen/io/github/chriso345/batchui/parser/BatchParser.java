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
  // variable|command|switch|label|COMMENT|CRLF
  //                     |ANNOTATION|TOGGLE
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = variable(b, l + 1);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = consumeToken(b, SWITCH);
    if (!r) r = label(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, ANNOTATION);
    if (!r) r = consumeToken(b, TOGGLE);
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
  // SETTER? KEY? SEPARATOR VALUE?
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE, "<variable>");
    r = variable_0(b, l + 1);
    r = r && variable_1(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && variable_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SETTER?
  private static boolean variable_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_0")) return false;
    consumeToken(b, SETTER);
    return true;
  }

  // KEY?
  private static boolean variable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean variable_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_3")) return false;
    consumeToken(b, VALUE);
    return true;
  }

}
