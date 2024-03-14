package br.leeloo.coinpaprika.features.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.leeloo.coinpaprika.core.navigation.DetailNavigation
import br.leeloo.coinpaprika.core.navigation.DetailScreenNav
import br.leeloo.coinpaprika.features.details.presentation.DetailScreen
import javax.inject.Inject

const val DETAIL_ROUTE = "detail_screen"
const val DETAILS_ID_ARGS = "DETAILS_ID_ARGS"
internal class DetailNavigationImpl @Inject constructor() : DetailNavigation {
    override fun navigateToDetail(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable(
            route = DetailScreenNav.Detail.route,
            arguments = listOf(
                navArgument(DETAILS_ID_ARGS) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            DetailScreen(navController, detailNavigation = this@DetailNavigationImpl)
        }
    }

    override fun navigateToDetail(navController: NavHostController, id: String) {
        navController.navigate(route = "$DETAIL_ROUTE/$id")
    }
}
