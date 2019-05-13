package com.test.kotlin.data.repository.main

import com.test.kotlin.mvp.model.api.MainApi
import com.test.kotlin.mvp.model.entity.State
import io.reactivex.Single

class MainRepositoryImpl(private val mApi: MainApi) : MainRepository {

    override fun getInfo(): Single<List<State>> {
        return mApi.getState()
            .map { it.getData() }
    }
}