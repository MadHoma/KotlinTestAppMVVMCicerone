package com.test.kotlin.di

import com.test.kotlin.mvp.model.api.MainApi
import org.koin.dsl.module.module
import retrofit2.Retrofit

val mainModule = module {
    single { get<Retrofit>().create(MainApi::class.java) }

    /**
    single { MainRepositoryImpl(get(), get(), get()) as MainRepository }
    single { MainRepository(get(), get(), get()) }
    single { MainValidator() }
    single { MainInteractor(get(), get()) }
    */
}