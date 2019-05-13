package com.test.kotlin.mvp.presentation

import com.arellomobile.mvp.InjectViewState
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.view.DetailView

@InjectViewState
class DetailPresenter : BasePresenter<DetailView>(){

    fun setItem(state: State?) {
        state?.let {
            viewState.showInfo(it)
        }
    }

}