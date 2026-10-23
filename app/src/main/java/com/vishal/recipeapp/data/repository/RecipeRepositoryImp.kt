package com.vishal.recipeapp.data.repository

import com.vishal.recipeapp.data.remote.dto.RecipesDTO
import com.vishal.recipeapp.data.remote.recipeapiservice.RecipeApiService
import com.vishal.recipeapp.domain.repository.RecipeRepository

class RecipeRepositoryImp (
    private val apiService: RecipeApiService
): RecipeRepository {

    override suspend fun getAllRecipes(): List<RecipesDTO> {
        return apiService.getAllRecipes().recipes
    }

    override suspend fun getRecipeById(id: Int): RecipesDTO {
        return apiService.getRecipeByID(id)
    }
}