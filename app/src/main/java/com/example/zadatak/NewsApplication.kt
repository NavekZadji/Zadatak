package com.example.zadatak

import android.app.Application
import org.koin.core.context.startKoin

class NewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModule, activityModule)
        }
    }
}