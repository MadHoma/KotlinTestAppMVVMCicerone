package com.test.kotlin.presentation

import android.app.Application
import org.koin.android.ext.android.startAndroidContext
import com.test.kotlin.di.*

class KotlinTestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startAndroidContext(this, listOf(AppModule(),
                ActivityModule(),
                UseCaseModule(),
                NetworkModule(),
                RepositoryModule()))
    }
}