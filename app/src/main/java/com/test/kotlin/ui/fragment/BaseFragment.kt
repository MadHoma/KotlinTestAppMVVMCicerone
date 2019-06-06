package com.test.kotlin.ui.fragment

import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment(), OnBackPressed {

    override fun onBackPressed(): Boolean {
        return false
    }
}