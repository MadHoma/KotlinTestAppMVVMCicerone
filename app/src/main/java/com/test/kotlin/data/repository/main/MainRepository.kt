package com.test.kotlin.data.repository.main

import com.test.kotlin.mvvm.model.entity.State
import io.reactivex.Single

interface MainRepository {

    fun getInfo() : Single<List<State>>
}