package com.test.kotlin.coordinator

import com.test.kotlin.mvvm.model.entity.State
import com.test.kotlin.ui.fragment.state.detail.DetailStateFragment
import com.test.kotlin.ui.fragment.state.list.ListStateFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    class StateListScreen(): SupportAppScreen(){
        override fun getFragment() = ListStateFragment.newInstance()
    }

    class DetailScreen(private val item: State): SupportAppScreen(){
        override fun getFragment() = DetailStateFragment.newInstance(item)
    }
}