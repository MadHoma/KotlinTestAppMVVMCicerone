package com.test.kotlin.mvvm.view.main

import android.arch.lifecycle.MutableLiveData
import com.test.kotlin.R
import com.test.kotlin.coordinator.Screens
import com.test.kotlin.domain.interactor.GetStateListInteractor
import com.test.kotlin.mvvm.model.entity.State
import com.test.kotlin.mvvm.view.BaseViewModel
import ru.terrakok.cicerone.Router
import java.net.UnknownHostException

class ListStateViewModel(
    private val mGetStateList: GetStateListInteractor,
    private val mRouter: Router
): BaseViewModel(){

    val list = MutableLiveData<List<State>>()
    val isLoading = MutableLiveData<Boolean>()
    val message = MutableLiveData<Int>()

    fun load(){
        mGetStateList.execute(
            {
                list.value = it
            },
            {
                if (it is UnknownHostException) {
                    message.value = R.string.network_error
                } else  message.value = R.string.unknown_error
                it.printStackTrace()
            },
            {
                isLoading.value = it
            }
        )
    }

    fun openDetail(item: State){
        mRouter.navigateTo(Screens.DetailScreen(item))
    }

}