package com.test.kotlin.di

import com.test.kotlin.domain.usecase.TestUseCase
import org.koin.android.module.AndroidModule

class UseCaseModule : AndroidModule() {

    override fun context() = applicationContext {
        provide { TestUseCase(get()) }
    }
}