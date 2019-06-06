package com.test.kotlin.di

import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val appModule = module {

    single { Cicerone.create<Router>(Router()) }
    single<Router> { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }

}