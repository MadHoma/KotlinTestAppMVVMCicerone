package com.test.kotlin.presentation.base.view

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import org.koin.standalone.KoinComponent
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>(), KoinComponent {

    private val mCompositeDisposable = CompositeDisposable()

    override fun detachView(view: V) {
        mCompositeDisposable.clear()
        super.detachView(view)

    }

}