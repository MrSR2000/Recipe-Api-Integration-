package com.example.myrecipe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoryState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoryState

    init {
        fetchCategories()
    }


    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    list = response.categories,
                    error = null,
                )
            } catch (e: Exception) {
                _categoryState.value = categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching categories : ${e.message}",
                )
            }
        }
    }


    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null,
    )
}