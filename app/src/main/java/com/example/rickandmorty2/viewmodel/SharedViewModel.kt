package com.example.rickandmorty2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty2.repository.Repository
import com.example.rickandmorty2.model.CharacterList
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(var repository: Repository): ViewModel() {
    var listCharacter = MutableLiveData<Response<CharacterList>>()

    fun getCharacter(page:Int){
        viewModelScope.launch {
            val character = repository.getCharacter(page)
            listCharacter.value = character
        }
    }
}