package br.leeloo.coinpaprika.features.details.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.features.details.presentation.uitls.detailDataPreview
import br.leeloo.coinpaprika.features.details.presentation.viewmodel.DetailViewState

internal const val LIST_VIEW_TAG = "ListViewTag"

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun DetailContent(
    modifier: Modifier = Modifier,
    state: DetailViewState,
    paddingValues: PaddingValues,
    coins: List<Coin>,
    onCollapse: (isExpanded: Boolean) -> Unit,
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .testTag(LIST_VIEW_TAG),
        columns = GridCells.Fixed(count = 3),
        contentPadding = paddingValues,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalArrangement = Arrangement.Top
    ) {
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            HeaderItemView(
                state = state,
                onCollapse = onCollapse
            )
        }

        items(coins) { items ->
            CoverView(
                coin = items,
            )
        }
    }
}

@Preview
@Composable
fun DetailContentPreview() {
    val state = DetailViewState(detail = detailDataPreview())
    val coins = emptyList<Coin>()


    DetailContent(
        modifier = Modifier.fillMaxWidth(),
        state = state,
        paddingValues = PaddingValues(),
        coins = coins,
        onCollapse = {},
    )
}
