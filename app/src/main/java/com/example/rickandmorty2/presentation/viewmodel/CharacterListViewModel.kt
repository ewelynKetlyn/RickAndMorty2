package com.example.rickandmorty2.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty2.repository.CharacterListRepository
import com.example.rickandmorty2.model.CharacterList
import kotlinx.coroutines.launch
import retrofit2.Response

class CharacterListViewModel(var repository: CharacterListRepository): ViewModel() {
    var listCharacter = MutableLiveData<Response<CharacterList>>()

    fun getCharacterList(page:Int){
        viewModelScope.launch {
            listCharacter.value = repository.getCharacter(page)
        }
    }
}

// criar