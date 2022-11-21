package com.ramadan.financeui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ramadan.financeui.R
import com.ramadan.financeui.ui.theme.CustomLightGreen

sealed class BottomNavItem(
    val route :String ,
    @StringRes val label : Int,
    @DrawableRes val icon : Int
){
    object Home : BottomNavItem(Screen.Home.route, R.string.home , R.drawable.home)
    object Wallet :  BottomNavItem(Screen.Wallet.route , R.string.wallet ,R.drawable.wallet)
    object Stats :  BottomNavItem(Screen.Stats.route , R.string.stats ,R.drawable.finance)
    object Profile :  BottomNavItem(Screen.Profile.route , R.string.profile ,R.drawable.user)
}


@Composable
fun BottomNavigationBar(navController: NavController){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Wallet,
        BottomNavItem.Stats,
        BottomNavItem.Profile,

    )

    BottomNavigation(
        backgroundColor = CustomLightGreen,
        contentColor = Color.White ,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.label)
                    , modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = stringResource(id = item.label)) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }

}