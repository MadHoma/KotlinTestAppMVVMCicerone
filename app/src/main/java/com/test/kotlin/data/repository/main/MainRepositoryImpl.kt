package com.test.kotlin.data.repository.main

import com.test.kotlin.mvvm.model.api.MainApi
import com.test.kotlin.mvvm.model.entity.State
import io.reactivex.Single

class MainRepositoryImpl(private val mApi: MainApi) : MainRepository {

    override fun getInfo(): Single<List<State>> {
        return mApi.getState()
            .map { it.getData() }
    }
}