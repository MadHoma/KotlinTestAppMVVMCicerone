package com.test.kotlin.mvp.view

import com.test.kotlin.presentation.base.view.BaseView

interface MainView: BaseView {
    fun showId(mId: Long)
}