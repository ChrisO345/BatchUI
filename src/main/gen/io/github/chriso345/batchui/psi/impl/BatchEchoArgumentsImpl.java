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

public class BatchEchoArgumentsImpl extends ASTWrapperPsiElement implements BatchEchoArguments {

  public BatchEchoArgumentsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitEchoArguments(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BatchTypes_> getTypes_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BatchTypes_.class);
  }

}
