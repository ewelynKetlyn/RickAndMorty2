package com.example.rickandmorty2.presentation.characterlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty2.domain.model.CharacterList
import com.example.rickandmorty2.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Response

internal class CharacterListViewModel (
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    var listCharacter = MutableLiveData<CharacterList>()

    fun getCharacterList(page:Int){
        viewModelScope.launch {
            getCharacterListUseCase(page)
                .flowOn(dispatcher)
                .collect{
                    listCharacter.value = it
                }
        }
    }
}