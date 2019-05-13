package com.test.kotlin.mvp.presentation

import android.util.Log
import com.test.kotlin.presentation.base.view.BasePresenter
import com.test.kotlin.mvp.view.MainView
import org.koin.standalone.inject

class MainPresenter() : BasePresenter<MainView>() {

    val string:String by inject()

    init {
        Log.d("LOGS", string)

    }


}