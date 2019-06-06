package com.test.kotlin.coordinator

import android.support.v7.app.AppCompatActivity
import com.test.kotlin.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

class NavigatorController(
    appCompatActivity: AppCompatActivity,
    containerId: Int
) : SupportAppNavigator(appCompatActivity, containerId) {

    override fun setupFragmentTransaction(
        command: Command?,
        currentFragment: android.support.v4.app.Fragment?,
        nextFragment: android.support.v4.app.Fragment?,
        fragmentTransaction: android.support.v4.app.FragmentTransaction?
    ) {
        if (command is Forward) {
            fragmentTransaction?.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
        }
    }
}