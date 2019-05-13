package com.test.kotlin.mvp.model.api

import com.test.kotlin.mvp.model.entity.State
import com.test.kotlin.mvp.model.entity.response.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {
    @GET("state/get/USA/all")
    fun getState(): Single<BaseResponse<List<State>>>
}