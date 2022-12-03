package com.example.rickandmorty2.domain.usecase

import com.example.rickandmorty2.domain.repository.CharacterListRepository
import com.example.rickandmorty2.stubCharacter
import com.example.rickandmorty2.stubCharacterList
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

@ExperimentalTime
class GetCharacterListUseCaseTest {
    private val repository = mockk<CharacterListRepository>()
    private val useCase = GetCharacterListUseCase(repository)

    @Test
    fun `invoke should return Character when repository returns success`() = runBlocking {
        //Given
        val character = stubCharacter
        every { repository.getCharacterList() } returns flowOf(character)

        //When
        val result = useCase.invoke()

        //Then
        result.test {
            assertEquals(character, expectItem())
            expectComplete()
        }
    }

    @Test
    fun `invoke should return Throwable when repository returns error`() = runBlocking {
        //Given
        val error = Throwable()
        every { repository.getCharacterList() } returns flow { throw error }

        //When
        val result = useCase.invoke()

        //Then
        result. {
            assertEquals(error, expectError())
        }
    }
}