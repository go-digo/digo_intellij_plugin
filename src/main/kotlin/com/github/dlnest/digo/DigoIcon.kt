package com.github.dlnest.digo


import com.intellij.openapi.util.IconLoader
import lombok.AccessLevel
import lombok.NoArgsConstructor


@NoArgsConstructor(access = AccessLevel.PRIVATE)
object DigoIcon {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    object Api {
        val ED = IconLoader.getIcon("/icon/api/ed.svg", javaClass)
    }

//    @NoArgsConstructor(access = AccessLevel.PRIVATE)
//    object HttpMethod {
//        val Post = IconLoader.getIcon("/icon/httpMethod/post.svg", javaClass)
//        val Del = IconLoader.getIcon("/icon/httpMethod/del.svg", javaClass)
//        val Put = IconLoader.getIcon("/icon/httpMethod/put.svg", javaClass)
//        val Get = IconLoader.getIcon("/icon/httpMethod/get.svg", javaClass)
//    }
//
//    @NoArgsConstructor(access = AccessLevel.PRIVATE)
//    object Tabs {
//        val ApiTab = IconLoader.getIcon("/icon/tabs/apiTab.svg", javaClass)
//    }
}

