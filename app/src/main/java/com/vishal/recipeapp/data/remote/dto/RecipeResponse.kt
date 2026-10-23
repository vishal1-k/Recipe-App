package com.vishal.recipeapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse (
    val recipes :List<RecipesDTO>,
    val total:Int,
    val skip:Int,
    val limit:Int
)