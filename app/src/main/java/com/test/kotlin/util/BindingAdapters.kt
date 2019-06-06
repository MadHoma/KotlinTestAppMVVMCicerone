package com.test.kotlin.util

import android.databinding.BindingAdapter
import android.view.View

object BindingAdapters {

    @BindingAdapter("isVisible")
    @JvmStatic
    fun bindIsVisible(view: View, visible: Boolean? = false){
        view.visibility = if(visible == true) View.VISIBLE else View.GONE
    }
}