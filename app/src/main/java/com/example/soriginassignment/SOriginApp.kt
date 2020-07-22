package com.example.soriginassignment

import android.app.Application
import com.example.soriginassignment.di.module.appModule
import com.example.soriginassignment.di.module.repoModule
import com.example.soriginassignment.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SOriginApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SOriginApp)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }



}