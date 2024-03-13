package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.features.coins.presentation.utils.coinDataPreview

const val COVER_VIEW_TAG = "CoverView"

@Composable
internal fun CoverView(
    coin: Coin?,
    onItemClick: (id: String) -> Unit
) {
    coin?.apply {
        Card(
            modifier = Modifier
                .testTag("${COVER_VIEW_TAG}_$id")
                .fillMaxWidth()
                .height(100.dp)
                .padding(4.dp)
                .clickable {
                    onItemClick(id)
                },
            shape = RoundedCornerShape(8.dp)

        ) {
            Box(
                modifier = Modifier.background(Color.Black)
            )
        }
    }
}

@Preview
@Composable
internal fun CoverViewPreview() {
    val coin = coinDataPreview()

    CoverView(
        coin = coin,
        onItemClick = {}
    )
}
