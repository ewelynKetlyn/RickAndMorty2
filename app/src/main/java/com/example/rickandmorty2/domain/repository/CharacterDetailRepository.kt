package com.example.rickandmorty2.domain.repository

import com.example.rickandmorty2.domain.model.Character
import kotlinx.coroutines.flow.Flow

internal interface CharacterDetailRepository {
    fun getCharacterDetail(id: Int): Flow<Character>
}