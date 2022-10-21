package com.example.rickandmorty2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty2.repository.CharacterListRepository

class CharacterListViewModelFactory(private val repository: CharacterListRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterListViewModel(repository) as T
    }
}

//criar a characterDetailViewModelFactory
//adicionar essa parada no detail fragment
//