package com.test.kotlin.di

import com.github.aurae.retrofit2.LoganSquareConverterFactory
import okhttp3.OkHttpClient
import org.koin.android.module.AndroidModule
import retrofit2.Retrofit
import com.test.kotlin.data.network.config.DefaultNetworkConfig
import com.test.kotlin.data.network.factory.RxErrorHandlingCallAdapterFactory
import java.util.concurrent.TimeUnit

class NetworkModule : AndroidModule() {

    override fun context() = applicationContext {
        provide { provideOkHttpClient(get()) }

        provide { provideBaseRetrofit(get(), get()) }

        provide { DefaultNetworkConfig() }
    }

    private fun provideOkHttpClient(defaultNetworkConfig: DefaultNetworkConfig): OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(60L, TimeUnit.SECONDS)
                    .readTimeout(60L, TimeUnit.SECONDS)
                    .addInterceptor(defaultNetworkConfig.getLoggingInterceptor())
                    .addInterceptor(defaultNetworkConfig.getAuthRequestInterceptor())
                    .build()

    private fun provideBaseRetrofit(httpClient: OkHttpClient, defaultNetworkConfig: DefaultNetworkConfig): Retrofit =
            Retrofit.Builder()
                    .baseUrl(defaultNetworkConfig.mBaseUrl)
                    .client(httpClient)
                    .addConverterFactory(LoganSquareConverterFactory.create())
                    .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                    .build()

}