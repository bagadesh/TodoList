package com.baga.todolist

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baga.todolist.home.Home
import com.bagadesh.baseui.theme.TodoListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            window?.statusBarColor = MaterialTheme.colors.onPrimary.toArgb()
            TodoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navHostController = rememberNavController()
                    NavHost(navController = navHostController, startDestination = "home") {
                        composable(route = "home") {
                            Home(
                                settingsClick = {
                                    navHostController.navigate(route = "settings")
                                }
                            )
                        }
                        composable(route = "settings") {
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(text = "Settings")
                            }
                        }
                    }
                }
            }
        }
    }
}

