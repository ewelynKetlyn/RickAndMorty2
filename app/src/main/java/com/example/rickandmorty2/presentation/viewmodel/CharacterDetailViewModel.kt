package com.example.rickandmorty2.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty2.repository.CharacterDetailRepository
import retrofit2.Response
import com.example.rickandmorty2.model.Character
import kotlinx.coroutines.launch

class CharacterDetailViewModel(var repository: CharacterDetailRepository): ViewModel() {

    var character = MutableLiveData<Response<Character>>()

    fun getCharacter(characterId: Int){
        viewModelScope.launch {
            character.value = repository.getCharacterDetail(characterId)
        }
    }
}