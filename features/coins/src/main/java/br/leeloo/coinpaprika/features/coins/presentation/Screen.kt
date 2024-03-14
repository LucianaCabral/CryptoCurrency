package br.leeloo.coinpaprika.features.coins.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.features.coins.R
import br.leeloo.coinpaprika.features.coins.presentation.component.AppBarView
import br.leeloo.coinpaprika.features.coins.presentation.component.CoinListView
import br.leeloo.coinpaprika.features.coins.presentation.viewmodel.CoinViewAction
import br.leeloo.coinpaprika.features.coins.presentation.viewmodel.CoinViewModel
import br.leeloo.coinpaprika.features.coins.presentation.viewmodel.CoinViewState
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun Screen(
    navController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel(),
    detailNavigation: DetailNavigation
) {
    CoinScaffold(
        state = viewModel.state.collectAsStateWithLifecycle(),
        navigateToDetail = viewModel::onItemClicked,
    )

    LaunchedEffect(viewModel) {
        viewModel.action.collectLatest { action ->
            when (action) {
                is CoinViewAction.ItemClicked ->
                    detailNavigation.navigateToDetail(navController,action.id)
            }
        }
    }
}

@Composable
private fun CoinScaffold(
    state: State<CoinViewState>,
    navigateToDetail: (id: String) -> Unit,
) {
    val coins = state.value.coins

    Scaffold(
        topBar = {
            AppBarView(titleRes = R.string.coin)
        },
        content = {
            CoinListView(
                paddingValues = it,
                coins = coins,
                onItemClick = navigateToDetail
            )
        }
    )
    println("<L> screen coins viewmodel = ${coins}")
}
