package br.leeloo.coinpaprika.features.coins.presentation.component

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource

const val APP_BAR_VIEW_TAG = "AppBarView"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AppBarView(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    textColor: Color = Color.White,
) {
    TopAppBar(
        modifier = modifier.testTag(APP_BAR_VIEW_TAG),
        title = {
            Text(
                text = stringResource(id = titleRes),
                color = textColor
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            Color.Black)
    )
}

