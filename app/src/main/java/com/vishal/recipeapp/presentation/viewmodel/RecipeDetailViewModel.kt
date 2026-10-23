package com.vishal.recipeapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vishal.recipeapp.data.remote.dto.RecipesDTO
import com.vishal.recipeapp.data.remote.ktorclient.KtorClient
import com.vishal.recipeapp.data.remote.recipeapiservice.RecipeApiService
import com.vishal.recipeapp.data.repository.RecipeRepositoryImp
import com.vishal.recipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeDetailViewModel : ViewModel(){

    private val repository : RecipeRepository =
        RecipeRepositoryImp(apiService = RecipeApiService(KtorClient.client))

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var recipe by mutableStateOf<RecipesDTO?>(null)
        private set


    fun fetchRecipeDetail(id:Int){

        isLoading = true
        errorMessage = null


        try {
            viewModelScope.launch {
                recipe = repository.getRecipeById(id)
            }
        }catch (e:Exception){
            errorMessage = e.message?: "An unexpected error occurred"
        }finally {
            isLoading = false
        }

    }

}