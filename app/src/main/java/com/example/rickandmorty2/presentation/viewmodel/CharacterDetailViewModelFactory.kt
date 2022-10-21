package com.example.rickandmorty2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty2.repository.CharacterDetailRepository

class CharacterDetailViewModelFactory(private val repository: CharacterDetailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterDetailViewModel(repository) as T
    }
}