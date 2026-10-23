package com.vishal.recipeapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.vishal.recipeapp.data.remote.dto.RecipesDTO
import com.vishal.recipeapp.data.remote.ktorclient.KtorClient
import com.vishal.recipeapp.data.remote.recipeapiservice.RecipeApiService
import com.vishal.recipeapp.data.repository.RecipeRepositoryImp
import com.vishal.recipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){

    private val repository: RecipeRepository =
        RecipeRepositoryImp(apiService = RecipeApiService(KtorClient.client))

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var recipes by mutableStateOf<List< RecipesDTO>>(emptyList())

    var selectedCategory by mutableStateOf("All")

    var categories by mutableStateOf<List<String>>(listOf("All"))
        private set

    private var allRecipes: List<RecipesDTO> = emptyList()

    init {
        fetchRecipes()
    }
    fun fetchRecipes(){
        isLoading = true
        errorMessage = null

        viewModelScope.launch {

            try {
                val result = repository.getAllRecipes()
                allRecipes = result

                val cuisines = result.map { it.cuisine }.distinct().sorted()
                categories = listOf("All") + cuisines

                applyFilters()
            }catch (
                e: Exception
            ){
                errorMessage = e.message?:"An unexpected error occurred"
            } finally {
                isLoading = false
            }
        }


    }

    fun onCategorySelected(category: String){
        selectedCategory = category
        applyFilters()
    }

    private fun applyFilters(){

        recipes =
            if(selectedCategory =="All") allRecipes
        else allRecipes.filter { it.cuisine == selectedCategory }
    }


}