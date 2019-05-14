package com.test.kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.test.kotlin.mvp.view.BaseView

abstract class BaseFragment : MvpAppCompatFragment(),OnBackPressed, BaseView {

    protected abstract val mLayoutResource: Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(mLayoutResource, container, false)
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}