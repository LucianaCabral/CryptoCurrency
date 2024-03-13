package br.leeloo.coinpaprika.features.coins.presentation

import android.widget.Toast
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
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
    viewModel: CoinViewModel = hiltViewModel()
) {
    CoinScaffold(
        state = viewModel.state.collectAsStateWithLifecycle(),
        navigateToDetail = viewModel::onItemClicked,
    )
    val context = LocalContext.current

    LaunchedEffect(viewModel) {
        viewModel.action.collectLatest { action ->
            when (action) {
                is CoinViewAction.ItemClicked ->
                    Toast.makeText(context, "not implemented", Toast.LENGTH_SHORT).show()
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
}
