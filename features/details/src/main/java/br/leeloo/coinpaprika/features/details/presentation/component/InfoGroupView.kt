package br.leeloo.coinpaprika.features.details.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.leeloo.coinpaprika.features.details.R
import br.leeloo.coinpaprika.features.details.domain.model.Detail
import br.leeloo.coinpaprika.features.details.presentation.uitls.detailDataPreview

@Composable
internal fun  InfoGroupView(
    modifier: Modifier = Modifier,
    detail: Detail = Detail()
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoView(
            name = stringResource(id = R.string.first_at),
            data = detail.firstDataAt.split("T")[0]
        )
        InfoView(
            name = stringResource(id = R.string.last_at),
            data = detail.lastDataAt.split("T")[0]
        )

        InfoView(
            name = stringResource(id = R.string.symbol),
            data = detail.symbol
        )
    }
}

@Composable
fun InfoView(
    name: String,
    data: String
) {
    Column {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = name,
            style = MaterialTheme.typography.titleSmall.copy(fontSize = 13.sp, letterSpacing = 1.sp),
            color = Color.DarkGray
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp),
            text = data,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
            color = Color.LightGray
        )
    }
}

@Preview
@Composable
fun InfoGroupViewPreview() {
    InfoGroupView(
        modifier = Modifier.fillMaxWidth(),
        detail = detailDataPreview()
    )
}
