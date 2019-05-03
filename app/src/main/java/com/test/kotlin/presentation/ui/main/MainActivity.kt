package com.test.kotlin.presentation.ui.main

import android.os.Bundle
import com.test.kotlin.R
import org.koin.android.ext.android.inject
import com.test.kotlin.di.ActivityModule
import com.test.kotlin.presentation.base.view.BaseActivity
import com.test.kotlin.presentation.base.view.toast

class MainActivity : BaseActivity<MainContract.View, MainContract.MainPresenter>(), MainContract.View {

    override val contextName = ActivityModule.CTX_MAIN_ACTIVITY

    override val mPresenter by inject<MainContract.MainPresenter>()

    override val mLayoutResource: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.getInfo()
    }

    override fun showId(mId: Long) {
        toast(mId.toString())
    }
}