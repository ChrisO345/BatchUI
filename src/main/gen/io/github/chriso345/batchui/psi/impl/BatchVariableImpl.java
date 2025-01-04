// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.chriso345.batchui.psi.BatchTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.chriso345.batchui.psi.*;

public class BatchVariableImpl extends ASTWrapperPsiElement implements BatchVariable {

  public BatchVariableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitVariable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getSetter() {
    return BatchPsiImplUtil.getSetter(this);
  }

  @Override
  public String getKey() {
    return BatchPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return BatchPsiImplUtil.getValue(this);
  }

}
