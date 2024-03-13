package br.leeloo.coinpaprika.features.coins.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.core.domain.usecase.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CoinViewModel @Inject constructor(
    private val coinUseCase: GetCoinUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _state: MutableStateFlow<CoinViewState> = MutableStateFlow(CoinViewState())
    val state: StateFlow<CoinViewState> = _state.asStateFlow()

    private val _action: Channel<CoinViewAction> = Channel<CoinViewAction>(Channel.CONFLATED)
    val action: Flow<CoinViewAction> = _action.receiveAsFlow()

    init {
        getCoin()
    }

    private fun getCoin() {
        viewModelScope.launch {
            coinUseCase()
                .flowOn(dispatcher)
                .onStart { }
                .catch { }
                .collectLatest(::onHandleSuccess)
        }
    }

    private fun onHandleSuccess(coins: List<Coin>) {
        _state.value = CoinViewState().handleSuccessState(coins)
    }

    fun onItemClicked(id: String) {
        _action.trySend(CoinViewAction.ItemClicked(id))
    }
}
