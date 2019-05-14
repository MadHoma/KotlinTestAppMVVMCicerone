package com.test.kotlin.coordinator

import com.test.kotlin.mvp.model.entity.State

class StateFlowCoordinator(private val navigator: Navigator) {
    fun openDetail(item : State){
        navigator.showDetail(item)
    }

    fun start(){
        navigator.showStateList()
    }
}