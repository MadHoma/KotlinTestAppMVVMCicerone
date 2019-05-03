package com.test.kotlin.presentation.ui.main

import com.test.kotlin.domain.base.UseCaseObserver
import com.test.kotlin.domain.usecase.TestUseCase
import com.test.kotlin.presentation.base.model.BaseModel
import com.test.kotlin.presentation.base.view.BasePresenter

class MainPresenter(private val mTestUseCase: TestUseCase) : BasePresenter<MainContract.View>(), MainContract.MainPresenter {

    override fun getInfo() {
        mTestUseCase.execute(InfoSubscriber())
    }

    inner class InfoSubscriber : UseCaseObserver.RxSingle<BaseModel>() {
        override fun onStart() {

        }

        override fun onSuccess(value: BaseModel) {
            mView?.showId(1)
        }

        override fun onError(e: Throwable) {

        }
    }

}