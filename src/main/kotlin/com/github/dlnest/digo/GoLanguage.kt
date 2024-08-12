package com.github.dlnest.digo

import com.intellij.lang.Language

class GoLanguage private constructor() :
    Language("go", *arrayOf<String>("text/go", "text/x-go", "application/x-go")) {
    override fun getDisplayName(): String {
        return "Go"
    }

    companion object {
        val INSTANCE: Language = GoLanguage()
    }
}
