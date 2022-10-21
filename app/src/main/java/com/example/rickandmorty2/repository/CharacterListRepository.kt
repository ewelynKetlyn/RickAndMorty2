package com.example.rickandmorty2.repository

import com.example.rickandmorty2.model.CharacterList
import com.example.rickandmorty2.network.RetrofitInstance
import retrofit2.Response

class CharacterListRepository {

    suspend fun getCharacter(page:Int): Response<CharacterList>{
        return RetrofitInstance.api.getCharacter(page)
    }
}