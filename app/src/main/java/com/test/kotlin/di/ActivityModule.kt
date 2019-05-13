package com.test.kotlin.di

import org.koin.dsl.module.module

object ActivityModule {

    const val CTX_MAIN_ACTIVITY = "MainActivity"
}

val activityModule = module {

    single { "asdasdasd" }
}