package br.leeloo.coinpaprika.core.domain.domain

import app.cash.turbine.test
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import br.leeloo.coinpaprika.core.domain.usecase.GetCoinUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
internal class GetCoinUseCaseTest {

        private val repository: CoinRepository = mockk(relaxed = true)
        private val subject = GetCoinUseCase(repository)

        @Test
        fun `getCoins Should return Coins When invoked`() = runBlocking {
            // Given

            val result = StubCoin.coinsDataList()

            every { repository.getCoins() } returns flow { emit(result) }

            // When
            val coinResult = subject.invoke()

            // Then
            coinResult.test {
                Assert.assertEquals(result, awaitItem())
                cancelAndConsumeRemainingEvents()
            }
            verify { repository.getCoins() }
        }

    @Test
        fun `getCoins Should return exception when invoked Coins`() = runBlocking {
            // Given
            val cause = Throwable()

            every { repository.getCoins() } returns flow { throw cause }

            // When
            val result = subject()

            // Then
            result.test {
                Assert.assertEquals(cause, awaitError())
            }
            verify { repository.getCoins() }
        }
}
