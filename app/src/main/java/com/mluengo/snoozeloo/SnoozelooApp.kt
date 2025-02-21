package com.mluengo.snoozeloo

import android.app.Application
import com.mluengo.snoozeloo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SnoozelooApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SnoozelooApp)
            androidLogger()

            modules(appModule)
        }
    }
}