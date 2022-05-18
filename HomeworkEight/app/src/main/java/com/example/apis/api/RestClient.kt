package com.example.apis.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient : OkHttpClient

    fun initClient() {
        okHttpClient = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun<T> getService(serviceClass : Class<T>): T {
        return retrofit.create(serviceClass)
    }

    val reqResApi : ReqResApi
    get () = getService(ReqResApi::class.java)
}