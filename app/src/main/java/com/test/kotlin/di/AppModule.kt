package com.test.kotlin.di

import com.test.kotlin.coordinator.Navigator
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {

    single { Navigator() }

}