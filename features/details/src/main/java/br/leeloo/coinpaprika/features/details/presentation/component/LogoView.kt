package br.leeloo.coinpaprika.features.details.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.leeloo.coinpaprika.features.details.presentation.uitls.detailDataPreview
import br.leeloo.coinpaprika.features.details.presentation.viewmodel.DetailViewState

internal const val BACKDROP_VIEW_TAG = "BackdropView"
internal const val PROGRESS_HEADER_VIEW_TAG = "ProgressHeaderView"
@Composable
internal fun LogoView(
    modifier: Modifier = Modifier,
    state: DetailViewState
) {
    Box(
        modifier = modifier
            .background(Color.Black)
            .testTag(BACKDROP_VIEW_TAG)
    ) {
        ImageLoaderView(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = state.detail.logo
        )

        if (state.shouldShowLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .testTag(PROGRESS_HEADER_VIEW_TAG),
                color = MaterialTheme.colorScheme.error
            )
        }

        if (state.errorMessage.isNotBlank()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                text = state.errorMessage,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun BackdropViewPreview() {
    val state = DetailViewState(detail = detailDataPreview())

    LogoView(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .width(100.dp),
        state = state
    )
}
