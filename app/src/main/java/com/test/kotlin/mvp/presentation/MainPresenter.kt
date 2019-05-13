package com.test.kotlin.mvp.presentation

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.test.kotlin.R
import com.test.kotlin.mvp.model.api.MainApi
import com.test.kotlin.mvp.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException

@SuppressLint("CheckResult")
@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    private val mApi: MainApi by inject()

    fun load(){
        mApi.getState()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { this.unSubscribeOnDestroy(it) }
            .doOnSubscribe { viewState.loading(true) }
            .doOnEvent { _, _ -> viewState.loading(false) }
            .subscribe(
                {
                   viewState.show(it.getData())
                },
                {
                    if(it is UnknownHostException){
                        viewState.showMessage(R.string.network_error)
                    } else viewState.showMessage(R.string.unknown_error)
                    it.printStackTrace()
                 })
    }

}