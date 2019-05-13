package com.test.kotlin.data.repository.main

import com.test.kotlin.mvp.model.entity.State
import io.reactivex.Single

interface MainRepository {

    fun getInfo() : Single<List<State>>
}