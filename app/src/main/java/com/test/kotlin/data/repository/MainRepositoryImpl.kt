package com.test.kotlin.data.repository

import com.test.kotlin.presentation.base.model.BaseModel
import io.reactivex.Single

class MainRepositoryImpl : MainRepository {

    override fun getInfo(): Single<BaseModel> {
        return Single.just(BaseModel())
    }
}