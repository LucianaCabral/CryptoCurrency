package br.leeloo.coinpaprika.features.details.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.leeloo.coinpaprika.features.details.domain.model.Team

const val TEAM_VIEW_TAG = "TeamView"
@Composable
internal fun TeamView(
    team: Team
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .testTag(TEAM_VIEW_TAG)
    ) {

        Text(
            text = team.name,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview
@Composable
fun TeamViewPreview() {
    TeamView(team = Team(name= "Bill", position= "1"))
}
