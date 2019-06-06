package com.test.kotlin.mvvm.view

import android.arch.lifecycle.ViewModel
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    private val cd: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        cd.clear()
        super.onCleared()
    }

    fun unSubscribeOnDestroy(disposable: Disposable) {
        cd.addAll(disposable)
    }

    protected fun <T> applySingleSchedulers(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { this.unSubscribeOnDestroy(it) }
    }

    fun clear(){
        cd.clear()
    }
}