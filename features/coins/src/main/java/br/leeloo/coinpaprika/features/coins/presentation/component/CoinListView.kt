package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.leeloo.coinpaprika.core.domain.model.Coin

@Composable
fun CoinListView(
    modifier: Modifier = Modifier,
    coins: List<Coin>
) {
    Box(
        modifier = modifier.background(Color.Black)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(coins) { coin ->
                CoinListItem(
                    coin = coin,
                )
            }
        }
    }
}
