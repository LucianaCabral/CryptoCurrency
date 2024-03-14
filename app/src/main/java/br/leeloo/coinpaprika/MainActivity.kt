package br.leeloo.coinpaprika

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.leeloo.coinpaprika.core.navigation.CoinNavigation
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.ui.theme.CoinPaprikaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var coinNavigation: CoinNavigation

    @Inject
    lateinit var detailNavigation: DetailNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CoinPaprikaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        navController = navController,
                        coinNavigation = coinNavigation,
                        detailNavigation = detailNavigation
                    )
                }
            }
        }
    }
}
