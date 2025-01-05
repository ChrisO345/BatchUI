// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class BatchVisitor extends PsiElementVisitor {

  public void visitLabel(@NotNull BatchLabel o) {
    visitPsiElement(o);
  }

  public void visitMisc(@NotNull BatchMisc o) {
    visitPsiElement(o);
  }

  public void visitSetLocal(@NotNull BatchSetLocal o) {
    visitPsiElement(o);
  }

  public void visitValueTypes(@NotNull BatchValueTypes o) {
    visitPsiElement(o);
  }

  public void visitVariable(@NotNull BatchVariable o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
