package com.example.rickandmorty2.repository

import retrofit2.Response
import com.example.rickandmorty2.model.Character
import com.example.rickandmorty2.network.RetrofitInstance

class CharacterDetailRepository {

    suspend fun getCharacterDetail(characterId: Int): Response<Character>{
        return RetrofitInstance.api.getCharacterDetail(characterId)
    }
}