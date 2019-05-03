package com.test.kotlin.presentation.base.view

interface Presenter<V> {

    fun attachView(view: V)

    fun isViewAttached(): Boolean

    fun detachView()

    var mView : V?

}