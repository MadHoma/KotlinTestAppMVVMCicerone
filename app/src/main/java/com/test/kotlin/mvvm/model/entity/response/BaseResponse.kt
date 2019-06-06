package com.test.kotlin.mvvm.model.entity.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<Data>(@SerializedName("RestResponse") val response: RestResponse<Data>) {

    class RestResponse<Data>(@SerializedName("result") val result: Data)

    fun getData() = response.result
}