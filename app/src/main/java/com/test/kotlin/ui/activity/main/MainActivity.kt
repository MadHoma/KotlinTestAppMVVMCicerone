package com.test.kotlin.ui.activity.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.test.kotlin.R
import com.test.kotlin.coordinator.NavigatorController
import com.test.kotlin.coordinator.Screens
import com.test.kotlin.ui.fragment.BaseFragment
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class MainActivity : AppCompatActivity() {

    private val mRouter: Router by inject()
    private val mNavigatorHolder: NavigatorHolder by inject()
    private val mNavigator = NavigatorController(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRouter.navigateTo(Screens.StateListScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        mNavigatorHolder.setNavigator(mNavigator)
    }

    override fun onPause() {
        super.onPause()
        mNavigatorHolder.removeNavigator()
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
            mRouter.exit()
        }
    }
}