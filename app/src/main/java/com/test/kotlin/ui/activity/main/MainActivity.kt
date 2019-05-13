package com.test.kotlin.ui.activity.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.kotlin.R
import com.test.kotlin.di.ActivityModule
import com.test.kotlin.mvp.presentation.MainPresenter
import com.test.kotlin.mvp.view.MainView
import com.test.kotlin.presentation.base.view.BaseActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<MainView>(), MainView {

    override val contextName = ActivityModule.CTX_MAIN_ACTIVITY


    override val mLayoutResource: Int = R.layout.activity_main
val string: String by inject()
    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showId(mId: Long) {

    }
}