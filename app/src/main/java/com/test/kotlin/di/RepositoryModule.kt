package com.test.kotlin.di

import org.koin.android.module.AndroidModule
import com.test.kotlin.data.repository.MainRepository
import com.test.kotlin.data.repository.MainRepositoryImpl

class RepositoryModule: AndroidModule() {

    override fun context() = applicationContext {
        provide { MainRepositoryImpl() } bind (MainRepository::class)
    }
}