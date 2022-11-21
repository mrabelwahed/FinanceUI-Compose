package com.ramadan.financeui.navigation

 sealed class Screen (val route :String) {
     object Home  :Screen("home_screen")
     object Wallet : Screen("wallet_screen")
     object Stats :Screen("stats_screen")
     object Profile : Screen("profile_screen")
}