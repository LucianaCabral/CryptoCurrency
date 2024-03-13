package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.leeloo.coinpaprika.core.domain.model.Coin
import br.leeloo.coinpaprika.features.coins.R
import br.leeloo.coinpaprika.features.coins.presentation.utils.coinDataPreview

const val COVER_VIEW_TAG = "CoverView"

@Composable
fun CoverView(
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
                modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.CenterStart)
                        .padding(8.dp),
                    text = stringResource(R.string.coin_rank, coin.rank, coin.name),
                    maxLines = 1,
                    fontSize = 20.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.BottomStart)
                        .padding(8.dp),
                    text = if (coin.isActive) stringResource(R.string.coin_active)
                    else stringResource(R.string.coin_inactive),
                    color =  if (coin.isActive) Color.Green else Color.Red,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Start,
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.CenterEnd)
                        .padding(8.dp),
                    text = stringResource(R.string.coin_symbol, coin.symbol),
                    color =  if (coin.isActive) Color.Green else Color.Red,
                    fontSize = 20.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}

@Preview
@Composable
internal fun CoverViewPreview() {
    val coin = coinDataPreview()

    CoverView(
        coin = coin
    ) {}
}
