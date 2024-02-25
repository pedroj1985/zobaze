package com.zobaze.zobazerefractortask.di

import com.zobaze.zobazerefractortask.MainApplication
import com.zobaze.zobazerefractortask.base.MainRepository

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

class AppCompositionRoot(
    private val application: MainApplication,
) {

    val repository by lazy {
        MainRepository(application)
    }

}