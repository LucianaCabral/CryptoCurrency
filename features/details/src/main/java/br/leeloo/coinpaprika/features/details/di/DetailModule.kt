package br.leeloo.coinpaprika.features.details.di

import br.leeloo.coinpaprika.core.data.remote.network.HttpClient
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.features.details.data.repository.DetailRepositoryImpl
import br.leeloo.coinpaprika.features.details.data.service.DetailService
import br.leeloo.coinpaprika.features.details.data.source.DetailDataSource
import br.leeloo.coinpaprika.features.details.data.source.DetailDataSourceImpl
import br.leeloo.coinpaprika.features.details.domain.repository.DetailRepository
import br.leeloo.coinpaprika.features.details.domain.usecase.GetDetailUseCase
import br.leeloo.coinpaprika.features.details.navigation.DetailNavigationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DetailModule {

    @Provides
    @Singleton
    fun provideService(
        httpClient: HttpClient
    ): DetailService {
        return httpClient.create(DetailService::class.java)
    }

    @Provides
    fun provideDetailRemoteDataSource(
        service: DetailService
    ): DetailDataSource {
        return DetailDataSourceImpl(service)
    }

    @Provides
    fun provideDetailRepository(
        detailDataSource: DetailDataSource
    ): DetailRepository {
        return DetailRepositoryImpl(detailDataSource)
    }

    @Provides
    fun provideGetDetailDetailUseCase(
        repository: DetailRepository
    ): GetDetailUseCase {
        return GetDetailUseCase(repository)
    }

    @Provides
    fun provideDetailNavigation(): DetailNavigation {
        return DetailNavigationImpl()
    }
}
