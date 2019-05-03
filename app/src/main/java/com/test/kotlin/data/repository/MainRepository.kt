package com.test.kotlin.data.repository

import com.test.kotlin.presentation.base.model.BaseModel
import io.reactivex.Single

interface MainRepository {

    fun getInfo() : Single<BaseModel>
}