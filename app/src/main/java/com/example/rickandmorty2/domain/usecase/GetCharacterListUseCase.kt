package com.example.rickandmorty2.domain.usecase

import com.example.rickandmorty2.domain.model.CharacterList
import com.example.rickandmorty2.domain.repository.CharacterListRepository
import kotlinx.coroutines.flow.Flow

internal class GetCharacterListUseCase(
    private val repository: CharacterListRepository
    ) {
    operator fun invoke(page: Int): Flow<CharacterList> {
        return repository.getCharacterList(page)
    }
}