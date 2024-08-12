package com.github.dlnest.digo.ui.contributor

import com.intellij.codeInsight.completion.*
import com.intellij.lang.ecmascript6.psi.impl.ES6ImportPsiUtil
import com.intellij.lang.ecmascript6.psi.impl.TypeScriptImportScope
import com.goide.psi.GoSpecType
import com.intellij.lang.javascript.ecmascript6.TypeScriptImportHandler
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiComment
import com.intellij.util.ProcessingContext


class CommentCompletion : CompletionContributor() {
    init {
        // 注释提示
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(PsiComment::class.java),
            object : CompletionProvider<CompletionParameters>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
//                    TypeScriptImportHandler.getInstance().importClass()
//                    resultSet.addElement(LookupElementBuilder.create("user1"))
//                    resultSet.addElement(LookupElementBuilder.create("user2"))
//                    resultSet.addElement(LookupElementBuilder.create("user3"))
                }
            }
        )
    }
}
