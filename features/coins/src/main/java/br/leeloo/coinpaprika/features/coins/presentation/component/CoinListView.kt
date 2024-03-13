package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.leeloo.coinpaprika.core.domain.model.Coin

@Composable
internal fun CoinListView(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    coins: List<Coin>,
    onItemClick: (id: String) -> Unit,
) {
    Box(
        modifier = modifier.background(Color.Black)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(count = 1),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalArrangement = Arrangement.Top
        ) {
            items(coins) { coins ->
                CoverView(
                    coin = coins,
                    onItemClick = onItemClick
                )
            }
        }
    }
}
