package com.example.rickandmorty2.domain.usecase

import com.example.rickandmorty2.domain.repository.CharacterDetailRepository
import kotlinx.coroutines.flow.Flow
import com.example.rickandmorty2.domain.model.Character

internal class GetCharacterDetailUseCase(private val repository: CharacterDetailRepository) {
    operator fun invoke(id:Int): Flow<Character>{
        return repository.getCharacterDetail(id)
    }
}