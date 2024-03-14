package br.leeloo.coinpaprika.features.details.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.leeloo.coinpaprika.features.details.domain.model.Detail
import br.leeloo.coinpaprika.features.details.domain.usecase.GetDetailUseCase
import br.leeloo.coinpaprika.features.details.navigation.DETAILS_ID_ARGS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    private val useCase: GetDetailUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(DetailViewState())
    val state: StateFlow<DetailViewState> = _state.asStateFlow()

    private val id
        get() = savedStateHandle.get<String>(DETAILS_ID_ARGS).orEmpty()

    fun getCoinDetails() {
        viewModelScope.launch {
            useCase(id)
                .onStart { _state.value = DetailViewState().copy(shouldShowLoading = true) }
                .flowOn(dispatcher)
                .catch {  }
                .collect(::getCoinDetailSuccess)
        }
    }

    private fun getCoinDetailSuccess(id: Detail) {
        _state.value = DetailViewState().setSuccessState(id)
        println("<L> DetailsScreen viewmodel = $id")
    }

    fun onCollapse(shouldCollapse: Boolean) {
        _state.value = DetailViewState().copy(shouldCollapseText = shouldCollapse)
    }
}
