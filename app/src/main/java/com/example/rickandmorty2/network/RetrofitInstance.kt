package com.example.rickandmorty2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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

//parei em 14:30