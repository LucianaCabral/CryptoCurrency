package br.leeloo.coinpaprika.features.details.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.leeloo.coinpaprika.features.details.R
import br.leeloo.coinpaprika.features.details.presentation.uitls.detailDataPreview
import br.leeloo.coinpaprika.features.details.presentation.viewmodel.DetailViewState
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

internal const val HEADER_ITEM_VIEW_TAG = "HeaderItemView"
internal const val COIN_TITLE_VIEW_TAG = "CoinTitleViewTag"

@OptIn(ExperimentalLayoutApi::class)
@ExperimentalLayoutApi
@Composable
internal fun HeaderItemView(
    state: DetailViewState,
    onCollapse: (isExpanded: Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(HEADER_ITEM_VIEW_TAG),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        LogoView(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .width(50.dp),
            state = state
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .testTag(COIN_TITLE_VIEW_TAG),
            text = state.detail.name,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        InfoGroupView(
            modifier = Modifier.fillMaxWidth(),
            detail = state.detail,
        )

        Spacer(modifier = Modifier.height(8.dp))

        DescriptionView(
            modifier = Modifier
                .fillMaxWidth(),
            shouldCollapseText = state.shouldCollapseText,
            description = state.detail.description,
            onCollapse = onCollapse
        )

        Spacer(modifier = Modifier.height(20.dp))

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            mainAxisSpacing = 10.dp,
            mainAxisAlignment = MainAxisAlignment.Center,
            crossAxisSpacing = 10.dp
        ) {
            state.detail.tags?.forEach { tag ->
                TagView(tag = tag)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = stringResource(R.string.team_members_title),
            color = Color.DarkGray,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            state.detail.team?.forEach { team ->
                TeamView(team = team)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable

fun HeaderItemViewPreview() {
    val state = DetailViewState(detail = detailDataPreview())

    HeaderItemView(
        state = state,
        onCollapse = {}
    )
}
