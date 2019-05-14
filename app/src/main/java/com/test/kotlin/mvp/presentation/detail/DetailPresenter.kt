package com.test.kotlin.mvp.presentation.detail

import com.arellomobile.mvp.InjectViewState
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.presentation.BasePresenter
import com.test.kotlin.mvp.view.detail.DetailView

@InjectViewState
class DetailPresenter : BasePresenter<DetailView>(){

    fun setItem(state: State?) {
        state?.let {
            viewState.showInfo(it)
        }
    }

}