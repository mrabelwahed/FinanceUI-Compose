package com.ramadan.financeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.ramadan.financeui.navigation.BottomNavigationBar
import com.ramadan.financeui.navigation.NavigationSetup
import com.ramadan.financeui.ui.theme.FinanceUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceUITheme {
                val navController =  rememberNavController()
              Scaffold(
                  bottomBar = { BottomNavigationBar(navController = navController)}

              ) {
                 Box(modifier = Modifier.padding(it)) {
                      NavigationSetup(navController = navController)
                  }

              }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FinanceUITheme {
    }
}