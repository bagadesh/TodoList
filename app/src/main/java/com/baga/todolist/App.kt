package com.baga.todolist

import android.app.Application
import android.os.Build
import com.baga.domain.debug.DebugConfigs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DebugConfigs.isDebugApplication = true
    }

}