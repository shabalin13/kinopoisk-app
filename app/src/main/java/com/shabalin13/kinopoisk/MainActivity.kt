package com.shabalin13.kinopoisk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.shabalin13.kinopoisk.navigation.AppNavGraph
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinopoiskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    AppNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        featureDependencies = (application as KinopoiskApplication).getFeatureDependencies()
                    )
                }
            }
        }
    }
}
