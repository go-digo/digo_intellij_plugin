package com.github.dlnest.digo.ui.codeInsight.lineMarker

import com.github.dlnest.digo.DigoIcon
import com.goide.psi.GoTypeSpec
import com.goide.psi.impl.GoTypeUtil
import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiElement
import org.jetbrains.annotations.NotNull
import java.awt.event.MouseEvent

internal class SimpleLineMarkerProvider : RelatedItemLineMarkerProvider() {

    override fun collectNavigationMarkers(
        @NotNull element: PsiElement,
        @NotNull result: MutableCollection<in RelatedItemLineMarkerInfo<*>?>
    ) {
        if (element is GoTypeSpec) {
            if (GoTypeUtil.isInterface(element)) {
                val identifier = element.identifier
                if (!element.name.isNullOrEmpty()) {
                    if (element.name?.endsWith("Api") == true) {
                        val builder =
                            NavigationGutterIconBuilder.create(DigoIcon.Api.ED)
                                .setTargets(identifier)
                                .setTooltipText("Navigate to Simple language property")
                        result.add(
                            builder.createLineMarkerInfo(
                                identifier,
                                CustomGutterIconNavigationHandler()
                            )
                        )
                    }
                }
            }
        }
    }

    private class CustomGutterIconNavigationHandler : GutterIconNavigationHandler<PsiElement> {
        override fun navigate(e: MouseEvent?, elt: PsiElement) {
            Messages.showInfoMessage("Async Action completed", "Information")
        }
    }
}


