package com.test.kotlin.data.network.config

import okhttp3.Interceptor

interface NetworkConfiguration {

    val mConnectionTimeout: Int

    val mBaseUrl: String

    val mInterceptors: List<Interceptor>

}