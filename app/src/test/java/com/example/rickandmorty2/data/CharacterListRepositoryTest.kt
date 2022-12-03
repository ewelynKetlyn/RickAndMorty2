package com.example.rickandmorty2.data

import com.example.rickandmorty2.data.datasource.characterlist.CharacterListRemoteDataSource
import kotlin.time.ExperimentalTime
import io.mockk.mockk

@ExperimentalTime
class CharacterListRepositoryTest {
    private val characterListRemoteDataSource = mockk<CharacterListRemoteDataSource>()
    //private val
}