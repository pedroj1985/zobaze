package com.zobaze.zobazerefractortask

import android.app.Application
import com.zobaze.zobazerefractortask.di.AppCompositionRoot

class MainApplication: Application() {

    val appCompositionRoot by lazy {
        AppCompositionRoot(this)
    }
}