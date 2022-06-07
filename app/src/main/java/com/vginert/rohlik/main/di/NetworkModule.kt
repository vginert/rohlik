package com.vginert.rohlik.main.di

import com.squareup.moshi.Moshi
import com.vginert.rohlik.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.GROCERY_API_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()
    }
}
