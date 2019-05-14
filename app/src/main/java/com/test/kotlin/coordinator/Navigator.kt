package com.test.kotlin.coordinator

import android.content.Context
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.ui.activity.detail.DetailActivity

class Navigator(private val application: Context){


    fun showDetail(item: State){
        val intent = DetailActivity.initIntent(application, item)
        application.startActivity(intent)
    }

}