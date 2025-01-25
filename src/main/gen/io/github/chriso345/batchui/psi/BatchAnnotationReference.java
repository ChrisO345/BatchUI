// This is a generated file. Not intended for manual editing.
package io.github.chriso345.batchui.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BatchAnnotationReference extends PsiElement {

  @Nullable
  BatchAssocArguments getAssocArguments();

  @Nullable
  BatchCallArguments getCallArguments();

  @Nullable
  BatchChdirArguments getChdirArguments();

  @Nullable
  BatchCommand getCommand();

  @Nullable
  BatchDateArguments getDateArguments();

  @Nullable
  BatchEchoArguments getEchoArguments();

  @Nullable
  BatchElseArguments getElseArguments();

  @Nullable
  BatchExitArguments getExitArguments();

  @Nullable
  BatchForArguments getForArguments();

  @Nullable
  BatchIfArguments getIfArguments();

  @Nullable
  BatchLabel getLabel();

  @Nullable
  BatchMoreArguments getMoreArguments();

  @Nullable
  BatchSetArguments getSetArguments();

  @Nullable
  BatchSetlocalArguments getSetlocalArguments();

  @Nullable
  BatchShiftArguments getShiftArguments();

  @Nullable
  BatchTypes_ getTypes_();

  @Nullable
  BatchUndefinedArguments getUndefinedArguments();

}
