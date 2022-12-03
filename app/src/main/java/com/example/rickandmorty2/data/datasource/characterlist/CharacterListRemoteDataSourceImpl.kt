package com.example.rickandmorty2.data.datasource.characterlist

import com.example.rickandmorty2.data.api.RetrofitService
import com.example.rickandmorty2.domain.model.CharacterList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterListRemoteDataSourceImpl(
    private val rickAndMortyService: RetrofitService
): CharacterListRemoteDataSource {
    override fun getCharacterList(page: Int): Flow<CharacterList> = flow {
        emit(rickAndMortyService.getCharacter(page))
    }
}
