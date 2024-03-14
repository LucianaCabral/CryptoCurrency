package br.leeloo.coinpaprika.features.details.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.features.details.R
import br.leeloo.coinpaprika.features.details.presentation.component.AppBarView
import br.leeloo.coinpaprika.features.details.presentation.component.DetailContent
import br.leeloo.coinpaprika.features.details.presentation.uitls.detailDataPreview
import br.leeloo.coinpaprika.features.details.presentation.viewmodel.DetailViewModel
import br.leeloo.coinpaprika.features.details.presentation.viewmodel.DetailViewState

@Composable
internal fun DetailScreen(
    navController: NavHostController,
    detailNavigation: DetailNavigation,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    viewModel.getCoinDetails()

    DetailScaffold(
        state = viewModel.state.collectAsState(),
        onCollapse = viewModel::onCollapse
    )
}

@Composable
private fun DetailScaffold(
    state: State<DetailViewState>,
    onCollapse: (isExpanded: Boolean) -> Unit,

    ) {
    val coinsDetails = state.value.coins

    Scaffold(
        topBar = {
            AppBarView(titleRes = R.string.coin_details)
        },
        content = {
            DetailContent(
                state = state.value,
                paddingValues = it,
                coins = coinsDetails,
                onCollapse = onCollapse
            )
            println("<L> Detailsscreen = ${coinsDetails}")
        }

    )
}

@Preview
@Composable
private fun DetailScreenPreview() {
    val state = remember { mutableStateOf(DetailViewState(detail = detailDataPreview())) }

    DetailScaffold(
        state = state,
        onCollapse = {}
    )
}
