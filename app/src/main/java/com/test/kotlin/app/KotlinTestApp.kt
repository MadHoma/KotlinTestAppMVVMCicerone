package com.test.kotlin.app

import android.app.Application
import com.test.kotlin.di.appModule
import com.test.kotlin.di.mainModule
import com.test.kotlin.di.networkModule
import org.koin.android.ext.android.startKoin

class KotlinTestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            appModule, networkModule, mainModule))
    }
}