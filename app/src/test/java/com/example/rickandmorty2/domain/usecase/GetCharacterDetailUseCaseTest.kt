package com.example.rickandmorty2.domain.usecase

import com.example.rickandmorty2.domain.repository.CharacterDetailRepository
import com.example.rickandmorty2.stubCharacter
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class GetCharacterDetailUseCaseTest {
    private val repository = mockk<CharacterDetailRepository>()
    private val useCase = GetCharacterDetailUseCase(repository)

    @Test
    fun `invoke should return Character when repository returns success`() = runBlocking {
        //Given
        val character = stubCharacter
        every { repository.getCharacterDetail() } returns flowOf(character)
        //When
        //Then
    }
}