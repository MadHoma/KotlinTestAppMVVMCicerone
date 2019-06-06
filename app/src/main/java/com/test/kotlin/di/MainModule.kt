package com.test.kotlin.di

import com.test.kotlin.data.repository.main.MainRepository
import com.test.kotlin.data.repository.main.MainRepositoryImpl
import com.test.kotlin.domain.interactor.GetStateListInteractor
import com.test.kotlin.mvvm.model.api.MainApi
import com.test.kotlin.mvvm.view.detail.DetailViewModel
import com.test.kotlin.mvvm.view.main.ListStateViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

val mainModule = module {

    single { get<Retrofit>().create(MainApi::class.java) }
    single<MainRepository> { MainRepositoryImpl(get())  }
    single { GetStateListInteractor(get()) }

    viewModel { ListStateViewModel(get(), get()) }
    viewModel { DetailViewModel() }
}