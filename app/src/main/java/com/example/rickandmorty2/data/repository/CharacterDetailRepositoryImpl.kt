package com.example.rickandmorty2.data.repository

import com.example.rickandmorty2.data.datasource.characterdetail.CharacterDetailRemoteDataSource
import com.example.rickandmorty2.data.datasource.characterlist.CharacterListRemoteDataSource
import com.example.rickandmorty2.domain.model.Character
import com.example.rickandmorty2.domain.model.CharacterList
import com.example.rickandmorty2.domain.repository.CharacterDetailRepository
import com.example.rickandmorty2.domain.repository.CharacterListRepository
import kotlinx.coroutines.flow.Flow

internal class CharacterDetailRepositoryImpl(
    private val characterDetailRemoteDataSource: CharacterDetailRemoteDataSource
): CharacterDetailRepository {
    override fun getCharacterDetail(id: Int): Flow<Character> =
        characterDetailRemoteDataSource.getCharacterDetail(id)
}