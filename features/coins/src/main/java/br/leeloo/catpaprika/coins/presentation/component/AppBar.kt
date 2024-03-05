package br.leeloo.catpaprika.coins.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    content: @Composable () -> Unit,
) {
    Scaffold(topBar = {
        Column(modifier = Modifier.height(48.dp)) {
            CenterAlignedTopAppBar(
                title = {
                    Text(title, color = Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }, content = { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            content()
        }
    })
}
