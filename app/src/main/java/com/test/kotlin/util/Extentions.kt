package com.test.kotlin.util

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

fun <T: ViewDataBinding> ViewGroup.binding(@LayoutRes layout: Int): T {
    return DataBindingUtil.inflate(LayoutInflater.from(context), layout, this, false)
}