package com.test.kotlin.presentation.ui.main

import com.test.kotlin.presentation.base.view.BaseView
import com.test.kotlin.presentation.base.view.Presenter

interface MainContract {

    interface View : BaseView {
        fun showId(mId: Long)

    }

    interface MainPresenter : Presenter<View> {
        fun getInfo()
    }
}