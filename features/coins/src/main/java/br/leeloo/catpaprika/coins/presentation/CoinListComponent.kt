package br.leeloo.catpaprika.coins.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.leeloo.catpaprika.coins.presentation.component.CoinListView
import br.leeloo.catpaprika.coins.presentation.viewmodel.CoinViewModel

@Composable
internal fun CoinListComponent(
    viewModel: CoinViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value
    Box(modifier = Modifier.fillMaxSize()) {
        CoinListView(
            coins = state.coins,
        )
    }
}
