package com.example.rickandmorty2.network

import com.example.rickandmorty2.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.rickandmorty2.model.Character

interface RetrofitService {

    @GET("api/character")
    suspend fun getCharacter(@Query("page") page: Int): Response<CharacterList>

    @GET("api/character/{id}")
    suspend fun getCharacterDetail(@Path("id") characterId: Int): Response<Character>
}