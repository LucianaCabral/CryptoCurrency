package br.leeloo.catpaprika.coins.data.di

import br.leeloo.catpaprika.coins.data.repository.CoinRepositoryImpl
import br.leeloo.catpaprika.coins.data.source.CoinDataSource
import br.leeloo.catpaprika.coins.data.source.CoinDataSourceImpl
import br.leeloo.coinpaprika.core.data.remote.network.HttpClient
import br.leeloo.coinpaprika.core.data.remote.service.CoinService
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import br.leeloo.coinpaprika.core.domain.usecase.GetCoinUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoinModule {
    @Provides
    @Singleton
    fun provideService(
        httpClient: HttpClient
    ): CoinService {
        return httpClient.create(CoinService::class.java)
    }

    @Provides
    fun provideCoinRemoteDataSource(
        service: CoinService
    ): CoinDataSource {
        return CoinDataSourceImpl(service = service)
    }

    @Provides
    fun provideCoinRepository(
        remoteDataSource: CoinDataSource
    ): CoinRepository {
        return CoinRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun provideGetGetCoinUseCase(
        repository: CoinRepository
    ): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
