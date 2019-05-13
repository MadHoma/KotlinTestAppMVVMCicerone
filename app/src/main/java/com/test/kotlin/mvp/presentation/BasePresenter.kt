package com.test.kotlin.mvp.presentation

import com.arellomobile.mvp.MvpPresenter
import com.test.kotlin.mvp.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.parameter.ParameterDefinition
import org.koin.core.parameter.emptyParameterDefinition
import org.koin.core.scope.Scope
import org.koin.standalone.StandAloneContext

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    inline fun <reified T : Any> inject(
        name: String = "",
        scope: Scope? = null,
        noinline parameters: ParameterDefinition = emptyParameterDefinition()
    ) = lazy {  StandAloneContext.getKoin().koinContext.get<T>(name, scope, parameters) }

    private val mCompositeDisposable = CompositeDisposable()


    fun unSubscribeOnDestroy(disposable: Disposable) {
        this.mCompositeDisposable.add(disposable)
    }

    override fun detachView(view: V) {
        mCompositeDisposable.clear()
        super.detachView(view)

    }

}