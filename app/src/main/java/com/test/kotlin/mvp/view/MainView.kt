package com.test.kotlin.mvp.view

import com.test.kotlin.presentation.base.view.BaseView
import com.test.kotlin.presentation.base.view.Presenter

interface MainView: BaseView {
    fun showId(mId: Long)
}