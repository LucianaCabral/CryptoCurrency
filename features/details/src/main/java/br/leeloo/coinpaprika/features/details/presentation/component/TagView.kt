package br.leeloo.coinpaprika.features.details.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.leeloo.coinpaprika.features.details.domain.model.Tag

@Composable
internal fun TagView(
    tag: Tag
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = tag.name,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview
@Composable
fun TagViewPreview() {
    TagView(tag = Tag(name = "Payment")
    )
}
