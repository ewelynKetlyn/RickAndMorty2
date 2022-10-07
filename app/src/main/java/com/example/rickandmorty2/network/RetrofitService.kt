package com.example.rickandmorty2.network

import com.example.rickandmorty2.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): Response<CharacterList>
}