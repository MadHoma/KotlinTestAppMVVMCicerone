package com.test.kotlin.coordinator

import android.support.v7.app.AppCompatActivity
import com.test.kotlin.R
import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.ui.fragment.state.detail.DetailStateFragment
import com.test.kotlin.ui.fragment.state.list.ListStateFragment

class Navigator(){

    var activty: AppCompatActivity? = null
    var containerId = R.id.container

    fun showStateList() {
        activty!!.supportFragmentManager
            .beginTransaction()
            .replace(containerId, ListStateFragment())
            .commit()

    }

    fun showDetail(item: State) {
        activty!!.supportFragmentManager
            .beginTransaction()
            .replace(containerId, DetailStateFragment.newInstance(item))
            .addToBackStack("StateDetail")
            .commit()
    }

}