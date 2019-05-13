package com.test.kotlin.mvp.view

import com.test.kotlin.mvp.model.entity.State

interface DetailView: BaseView {
    fun showInfo(item: State)
}