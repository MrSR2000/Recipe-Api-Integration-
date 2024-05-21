package com.example.myrecipe

sealed class Screen(val route: String) {
    object RecipeScreen : Screen("recipeScreen")
    object DetailScreen : Screen("detailScreen")
}