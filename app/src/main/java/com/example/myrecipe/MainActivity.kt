package com.example.myrecipe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myrecipe.ui.theme.MyRecipeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            MyRecipeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp)
                ) {
//                    MyApp()
                    RecipeApp(navController = navController)
                }
            }
        }
    }
}

//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "firstScreen") {
//        composable(route = "firstScreen") {
//            RecipeScreen(navigateToDetailScreen = { navController.navigate("detailScreen") })
//        }
//        composable(route = "detailScreen") {
//            ProductDetailScreen(
//
//            )
//
//        }
//    }
//}