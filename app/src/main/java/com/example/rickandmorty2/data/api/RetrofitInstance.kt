package com.example.rickandmorty2.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}
