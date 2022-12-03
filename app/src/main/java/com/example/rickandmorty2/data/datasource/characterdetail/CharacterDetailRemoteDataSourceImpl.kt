package com.example.rickandmorty2.data.datasource.characterdetail

import com.example.rickandmorty2.data.api.RetrofitService
import com.example.rickandmorty2.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterDetailRemoteDataSourceImpl(
    private val rickAndMortyService: RetrofitService
): CharacterDetailRemoteDataSource {
    override fun getCharacterDetail(id: Int): Flow<Character> = flow {
        emit(rickAndMortyService.getCharacterDetail(characterId = id))
    }

}