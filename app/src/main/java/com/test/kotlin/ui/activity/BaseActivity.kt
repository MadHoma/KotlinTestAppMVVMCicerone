package com.test.kotlin.ui.activity

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.view.LayoutInflater
import com.arellomobile.mvp.MvpAppCompatActivity
import com.test.kotlin.mvp.view.BaseView

abstract class BaseActivity<V : BaseView> : MvpAppCompatActivity(),
    BaseView {

    private var mRootView: android.view.View? = null

    protected abstract val mLayoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflatedView = LayoutInflater.from(this).inflate(mLayoutResource, null)
        if (inflatedView is CoordinatorLayout) {
            mRootView = inflatedView
        } else {
            mRootView = CoordinatorLayout(this)
            (mRootView as CoordinatorLayout).addView(inflatedView,
                    CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                            CoordinatorLayout.LayoutParams.MATCH_PARENT))
        }

        setContentView(mRootView)
    }


}
