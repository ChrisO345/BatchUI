// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BatchStandardIf extends PsiElement {

  @Nullable
  BatchCommand getCommand();

  @NotNull
  List<BatchLabel> getLabelList();

  @NotNull
  BatchOperators getOperators();

  @NotNull
  List<BatchPrefix> getPrefixList();

}
