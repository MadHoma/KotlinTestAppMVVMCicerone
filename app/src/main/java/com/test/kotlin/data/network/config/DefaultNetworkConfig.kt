package com.test.kotlin.data.network.config

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class DefaultNetworkConfig : NetworkConfiguration {

    companion object {
        private val HEADER_SESSION_TOKEN = "Token"
        private val CONNECTION_TIMEOUT_SECONDS = 40
    }

    override val mBaseUrl: String = ""

    override val mConnectionTimeout: Int = CONNECTION_TIMEOUT_SECONDS

    override val mInterceptors: List<Interceptor> = arrayListOf(getAuthRequestInterceptor(), getLoggingInterceptor())

    fun getLoggingInterceptor(): Interceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    fun getAuthRequestInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()

            val authHeaderKey = this@DefaultNetworkConfig.mAuthTokenHeaderKey
            val authHeaderToken = this@DefaultNetworkConfig.mAuthToken

            if (authHeaderToken != null) {
                request = request.newBuilder()
                        .addHeader(authHeaderKey, authHeaderToken)
                        .build()
            }
            chain.proceed(request)
        }
    }

    private val mAuthTokenHeaderKey = HEADER_SESSION_TOKEN

    private val mAuthToken : String? = null
}