package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.leeloo.catpaprika.coins.R
import br.leeloo.coinpaprika.core.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(
                R.string.coin_rank, coin.rank, coin.name
            ),
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = Color.Blue,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = stringResource(R.string.coin_symbol, coin.symbol),
            color = Color.Magenta,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoinListItemPreview() {
    CoinListItem(
        coin = Coin(
            "1",
            isActive = true,
            symbol = "BTC",
            name = "Bitcoin",
            rank = 1,
            isNew = true,
            type = "coin"
        )
    )
}
