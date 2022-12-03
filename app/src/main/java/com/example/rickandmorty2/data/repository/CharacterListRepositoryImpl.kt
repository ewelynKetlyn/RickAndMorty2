package com.example.rickandmorty2.data.repository

import com.example.rickandmorty2.data.datasource.characterlist.CharacterListRemoteDataSource
import com.example.rickandmorty2.domain.model.CharacterList
import com.example.rickandmorty2.domain.repository.CharacterListRepository
import kotlinx.coroutines.flow.Flow

internal class CharacterListRepositoryImpl(
    private val characterListRemoteDataSource: CharacterListRemoteDataSource
): CharacterListRepository {
    override fun getCharacterList(page: Int): Flow<CharacterList> =
        characterListRemoteDataSource.getCharacterList(page)
}