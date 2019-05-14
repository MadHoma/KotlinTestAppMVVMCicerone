package com.test.kotlin.ui.activity.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.test.kotlin.R
import com.test.kotlin.coordinator.Navigator
import com.test.kotlin.ui.fragment.BaseFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.activty = this
        navigator.showStateList()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (fragment != null
            && fragment is BaseFragment
            && fragment.onBackPressed()
        ) {
            return
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.activty = null
    }
}