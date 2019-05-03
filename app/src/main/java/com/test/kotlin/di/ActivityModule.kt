package com.test.kotlin.di

import org.koin.android.module.AndroidModule
import com.test.kotlin.presentation.ui.main.MainContract
import com.test.kotlin.presentation.ui.main.MainPresenter

class ActivityModule : AndroidModule() {

    companion object {
        const val CTX_MAIN_ACTIVITY = "MainActivity"
    }

    override fun context() = applicationContext {
        context(name = CTX_MAIN_ACTIVITY) {
            provide { MainPresenter(get()) } bind (MainContract.MainPresenter::class)
        }

    }
}