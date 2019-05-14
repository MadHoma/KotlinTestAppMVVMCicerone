package com.test.kotlin.mvp.view.main

import android.support.annotation.StringRes
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.view.BaseView

interface MainView: BaseView {

    fun show(list: List<State>)

    fun loading(isShowLoading: Boolean)

    fun showMessage(@StringRes res: Int)
}