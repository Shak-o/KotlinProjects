package com.example.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : ReqResApi by lazy {
        Retrofit.Builder().baseUrl("https://reqres.in").addConverterFactory(GsonConverterFactory.create()).build().create(ReqResApi::class.java)
    }
}