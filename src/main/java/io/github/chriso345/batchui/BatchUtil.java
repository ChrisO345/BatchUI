package io.github.chriso345.batchui;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.chriso345.batchui.psi.BatchFile;
import io.github.chriso345.batchui.psi.BatchVariable;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BatchUtil {
    /**
     * Searches the entire project for Batch language files with instances of the Batch property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<BatchVariable> findProperties(Project project, String key) {
        List<BatchVariable> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(BatchFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            BatchFile batchFile = (BatchFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (batchFile != null) {
                BatchVariable[] properties = PsiTreeUtil.getChildrenOfType(batchFile, BatchVariable.class);
                if (properties != null) {
                    for (BatchVariable property : properties) {
                        if (key.equals(property.getKey())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<BatchVariable> findProperties(Project project) {
        List<BatchVariable> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(BatchFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            BatchFile batchFile = (BatchFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (batchFile != null) {
                BatchVariable[] properties = PsiTreeUtil.getChildrenOfType(batchFile, BatchVariable.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

    /**
     * Attempts to collect any comment elements above the Batch key/value pair.
     */
    @NotNull
    public static String findDocumentationComment(BatchVariable property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result), "\n ");
    }
}
