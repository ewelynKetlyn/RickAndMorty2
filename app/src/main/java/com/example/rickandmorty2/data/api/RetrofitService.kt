package com.example.rickandmorty2.data.api

import com.example.rickandmorty2.domain.model.Character
import com.example.rickandmorty2.domain.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("api/character")
    suspend fun getCharacter(@Query("page") page: Int): CharacterList

    @GET("api/character/{id}")
    suspend fun getCharacterDetail(@Path("id") characterId: Int): Character
}