package com.test.kotlin

import android.app.Application
import com.test.kotlin.di.activityModule
import org.koin.android.ext.android.startKoin

class KotlinTestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(activityModule))
    }
}