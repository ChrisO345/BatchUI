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

public class BatchExistIfImpl extends ASTWrapperPsiElement implements BatchExistIf {

  public BatchExistIfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitExistIf(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatchCommand getCommand() {
    return findChildByClass(BatchCommand.class);
  }

  @Override
  @NotNull
  public List<BatchLabel> getLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BatchLabel.class);
  }

  @Override
  @NotNull
  public List<BatchPrefix> getPrefixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BatchPrefix.class);
  }

}
