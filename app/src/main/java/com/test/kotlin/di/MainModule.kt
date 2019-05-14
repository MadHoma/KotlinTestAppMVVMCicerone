package com.test.kotlin.di

import com.test.kotlin.coordinator.StateFlowCoordinator
import com.test.kotlin.data.repository.main.MainRepository
import com.test.kotlin.data.repository.main.MainRepositoryImpl
import com.test.kotlin.domain.interactor.GetStateListInteractor
import com.test.kotlin.mvp.model.api.MainApi
import org.koin.dsl.module.module
import retrofit2.Retrofit

val mainModule = module {

    single { get<Retrofit>().create(MainApi::class.java) }
    single<MainRepository> { MainRepositoryImpl(get())  }
    single { GetStateListInteractor(get()) }

    single { StateFlowCoordinator(get()) }
}