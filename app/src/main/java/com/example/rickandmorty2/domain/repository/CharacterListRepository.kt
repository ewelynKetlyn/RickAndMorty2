package com.example.rickandmorty2.domain.repository

import com.example.rickandmorty2.domain.model.CharacterList
import kotlinx.coroutines.flow.Flow

internal interface CharacterListRepository{
    fun getCharacterList(page: Int): Flow<CharacterList>
}