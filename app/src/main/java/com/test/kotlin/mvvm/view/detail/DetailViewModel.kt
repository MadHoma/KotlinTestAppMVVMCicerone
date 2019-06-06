package com.test.kotlin.mvvm.view.detail

import android.arch.lifecycle.MutableLiveData
import com.test.kotlin.mvvm.model.entity.State
import com.test.kotlin.mvvm.view.BaseViewModel

class DetailViewModel : BaseViewModel(){

    val state = MutableLiveData<State>()

}