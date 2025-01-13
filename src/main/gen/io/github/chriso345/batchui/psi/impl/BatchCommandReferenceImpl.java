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

public class BatchCommandReferenceImpl extends ASTWrapperPsiElement implements BatchCommandReference {

  public BatchCommandReferenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitCommandReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatchAssocArguments getAssocArguments() {
    return findChildByClass(BatchAssocArguments.class);
  }

  @Override
  @Nullable
  public BatchCallArguments getCallArguments() {
    return findChildByClass(BatchCallArguments.class);
  }

  @Override
  @Nullable
  public BatchChdirArguments getChdirArguments() {
    return findChildByClass(BatchChdirArguments.class);
  }

  @Override
  @Nullable
  public BatchCommand getCommand() {
    return findChildByClass(BatchCommand.class);
  }

  @Override
  @Nullable
  public BatchEchoArguments getEchoArguments() {
    return findChildByClass(BatchEchoArguments.class);
  }

  @Override
  @Nullable
  public BatchElseArguments getElseArguments() {
    return findChildByClass(BatchElseArguments.class);
  }

  @Override
  @Nullable
  public BatchExitArguments getExitArguments() {
    return findChildByClass(BatchExitArguments.class);
  }

  @Override
  @Nullable
  public BatchForArguments getForArguments() {
    return findChildByClass(BatchForArguments.class);
  }

  @Override
  @Nullable
  public BatchIfArguments getIfArguments() {
    return findChildByClass(BatchIfArguments.class);
  }

  @Override
  @Nullable
  public BatchLabel getLabel() {
    return findChildByClass(BatchLabel.class);
  }

  @Override
  @Nullable
  public BatchMoreArguments getMoreArguments() {
    return findChildByClass(BatchMoreArguments.class);
  }

  @Override
  @Nullable
  public BatchSetArguments getSetArguments() {
    return findChildByClass(BatchSetArguments.class);
  }

  @Override
  @Nullable
  public BatchSetlocalArguments getSetlocalArguments() {
    return findChildByClass(BatchSetlocalArguments.class);
  }

  @Override
  @Nullable
  public BatchShiftArguments getShiftArguments() {
    return findChildByClass(BatchShiftArguments.class);
  }

  @Override
  @Nullable
  public BatchTypes_ getTypes_() {
    return findChildByClass(BatchTypes_.class);
  }

  @Override
  @Nullable
  public BatchUndefinedArguments getUndefinedArguments() {
    return findChildByClass(BatchUndefinedArguments.class);
  }

}
