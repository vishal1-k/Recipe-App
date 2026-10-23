package com.vishal.recipeapp.domain.repository

import com.vishal.recipeapp.data.remote.dto.RecipesDTO

interface RecipeRepository {

    suspend fun getAllRecipes(): List<RecipesDTO>

    suspend fun getRecipeById(id:Int): RecipesDTO

}