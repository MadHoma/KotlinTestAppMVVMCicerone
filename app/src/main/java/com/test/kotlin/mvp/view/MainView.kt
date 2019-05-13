package com.test.kotlin.mvp.view

import android.support.annotation.StringRes
import com.test.kotlin.mvp.model.entity.State

interface MainView: BaseView {

    fun show(list: List<State>)

    fun loading(isShowLoading: Boolean)

    fun showMessage(@StringRes res: Int)
}