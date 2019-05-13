package com.test.kotlin.di

import com.test.kotlin.presentation.base.model.BaseModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import org.koin.dsl.module.module

object ActivityModule {

    const val CTX_MAIN_ACTIVITY = "MainActivity"
}

val activityModule = module {

    single { "asdasdasd" }
}