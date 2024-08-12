package com.github.dlnest.digo.action

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import lombok.Setter
import java.util.*
import java.util.function.Consumer
import javax.swing.Icon


class ButtonAction(text: String, description: String, icon: Icon?) : AnAction(text, description, icon) {

    constructor() : this("", "", AllIcons.FileTypes.Dtd)

    @Setter
    private var action: Consumer<AnActionEvent>? = null

    @Setter
    private val isEnabled = true

    fun setAddAction(action: Consumer<AnActionEvent>) {
        this.action = action
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        if (Objects.nonNull(action)) {
            action!!.accept(anActionEvent)
        }
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabled = isEnabled
    }
}
