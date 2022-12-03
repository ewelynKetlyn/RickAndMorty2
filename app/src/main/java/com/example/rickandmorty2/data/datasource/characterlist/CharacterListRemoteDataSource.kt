package com.example.rickandmorty2.data.datasource.characterlist

import com.example.rickandmorty2.domain.model.CharacterList
import kotlinx.coroutines.flow.Flow

internal interface CharacterListRemoteDataSource {
    fun getCharacterList(page: Int): Flow<CharacterList>
}