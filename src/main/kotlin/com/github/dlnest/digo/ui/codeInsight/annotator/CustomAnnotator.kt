package com.github.dlnest.digo.ui.codeInsight.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement

class CustomAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (holder.isBatchMode) return
        if (element is PsiComment) {
            atAnnotator(element, holder, "GroupPath")
            atAnnotator(element, holder, "OnlyPath")
        }
    }

    private fun atAnnotator(element: PsiElement, holder: AnnotationHolder, key: String) {
        val sign = "// "
        val prefix = "$sign@$key: "
        val text = element.text
        if (text.startsWith(prefix, true)) {
            // 注释
            val parameterRange = TextRange.from(element.textRange.startOffset, sign.length)
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(parameterRange)
                .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT).create()
            // @对象
            val atKeyRange =
                TextRange(parameterRange.endOffset, parameterRange.endOffset + (prefix.length - sign.length))
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(atKeyRange)
                .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT_TAG).create()
            // 值
            val parameter = text.substring(prefix.length).trim()
            if (parameter.isNotEmpty()) {
                val valueRange = TextRange(atKeyRange.endOffset, element.textRange.endOffset)
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(valueRange)
                    .textAttributes(DefaultLanguageHighlighterColors.DOC_COMMENT_TAG_VALUE).create()
            }
        }
    }
}