package com.example.rickandmorty2.presentation.characterdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty2.domain.repository.CharacterDetailRepository
import retrofit2.Response
import com.example.rickandmorty2.domain.model.Character
import com.example.rickandmorty2.domain.usecase.GetCharacterDetailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var character = MutableLiveData<Character>()

    fun getCharacter(characterId: Int) {
        viewModelScope.launch {
            getCharacterDetailUseCase(characterId)
                .flowOn(dispatcher)
                .collect{
                    character.value = it
                }
        }
    }
}