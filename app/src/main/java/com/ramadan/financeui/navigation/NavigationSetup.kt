package com.ramadan.financeui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ramadan.financeui.HomeScreen
import com.ramadan.financeui.screens.ProfileScreen
import com.ramadan.financeui.screens.StatsScreen
import com.ramadan.financeui.screens.WalletScreen

@Composable
fun NavigationSetup (navController : NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(Screen.Home.route){
            HomeScreen()
        }
        composable(Screen.Wallet.route){
           WalletScreen()
        }
        composable(Screen.Stats.route){
            StatsScreen()
        }
        composable(Screen.Stats.route){
            StatsScreen()
        }
        composable(Screen.Profile.route){
            ProfileScreen()
        }
    }
}