package com.example.rickandmorty2.data.datasource.characterdetail

import kotlinx.coroutines.flow.Flow
import com.example.rickandmorty2.domain.model.Character

internal interface CharacterDetailRemoteDataSource {
    fun getCharacterDetail(page: Int): Flow<Character>
}