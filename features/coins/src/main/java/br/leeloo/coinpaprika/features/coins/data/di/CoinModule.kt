package br.leeloo.coinpaprika.features.coins.data.di

import br.leeloo.coinpaprika.features.coins.data.repository.CoinRepositoryImpl
import br.leeloo.coinpaprika.features.coins.data.source.CoinDataSource
import br.leeloo.coinpaprika.features.coins.data.source.CoinDataSourceImpl
import br.leeloo.coinpaprika.core.data.remote.network.HttpClient
import br.leeloo.coinpaprika.core.data.remote.service.CoinService
import br.leeloo.coinpaprika.core.domain.repository.CoinRepository
import br.leeloo.coinpaprika.core.domain.usecase.GetCoinUseCase
import br.leeloo.coinpaprika.core.navigation.CoinNavigation
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.features.coins.navigation.CoinNavigationImpl
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

    @Provides
    fun provideCoinNavigation(
        detailNavigation: DetailNavigation
    ): CoinNavigation {
        return CoinNavigationImpl(detailNavigation)
    }
}

