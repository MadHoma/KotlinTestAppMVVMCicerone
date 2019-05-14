package com.test.kotlin.mvp.view.detail

import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.view.BaseView

interface DetailView: BaseView {
    fun showInfo(item: State)
}