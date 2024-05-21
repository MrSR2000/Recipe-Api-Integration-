package com.example.myrecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    navigateToDetailScreen: (Category) -> Unit,
    viewState: MainViewModel.RecipeState
) {
    val recipeViewModel: MainViewModel = viewModel()

    //UI
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "ERROR : ${viewState.error}")
            }


            else -> {
                CategoryScreen(
                    categories = viewState.list,
                    navigateToDetailScreen = navigateToDetailScreen
                )

            }
        }
    }
}

//item grid list
@Composable
fun CategoryScreen(
    categories: List<Category>,
    navigateToDetailScreen: (Category) -> Unit

) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                navigateToDetailScreen = navigateToDetailScreen
            )
        }
    }
}

//How items look like
@Composable
fun CategoryItem(
    category: Category,
    navigateToDetailScreen: (Category) -> Unit

) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable { navigateToDetailScreen(category) },
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = rememberAsyncImagePainter(
                category.strCategoryThumb, placeholder = painterResource(
                    R.drawable.ic_launcher_background
                )
            ),

            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f),
        )





        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}