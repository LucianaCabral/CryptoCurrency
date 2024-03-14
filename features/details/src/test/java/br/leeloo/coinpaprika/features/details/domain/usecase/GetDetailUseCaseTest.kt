package br.leeloo.coinpaprika.features.details.domain.usecase

import app.cash.turbine.test
import br.leeloo.coinpaprika.features.details.domain.repository.DetailRepository
import br.leeloo.coinpaprika.features.details.domain.usecase.StubDetail.getDetails
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
internal class DetailUseCaseTest {

    private val repository: DetailRepository = mockk(relaxed = true)
    private val subject = GetDetailUseCase(repository)

    @Test
    fun `getDetails Should return Details When invoked`() = runBlocking {
        // Given

        val result = getDetails()

        every { repository.getDetails(result.id) } returns flow { emit(result) }

        // When
        val breedResult = subject.invoke(result.id)

        // Then
        breedResult.test {
            Assert.assertEquals(result, awaitItem())
            cancelAndConsumeRemainingEvents()
        }
        verify { repository.getDetails(result.id) }
    }

    @Test
    fun `getDetails Should return exception when invoked Details`() = runBlocking {
        // Given
        val cause = Throwable()
        val detail = getDetails()
        every { repository.getDetails(detail.id) } returns flow { throw cause }

        // When
        val result = subject(detail.id)

        // Then
        result.test {
            Assert.assertEquals(cause, awaitError())
        }
        verify { repository.getDetails(detail.id) }
    }
}