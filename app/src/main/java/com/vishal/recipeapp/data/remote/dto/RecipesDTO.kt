package com.vishal.recipeapp.data.remote.dto

import kotlinx.serialization.Serializable

// DTO stands Data Transfer Object
// ye ek kotlin data class h jo api se ane wale  json data k store kar ti hai

@Serializable
data class RecipesDTO(
    val id:Int,
    val name:String,
    val cookTimeMinutes:Int,
    val caloriesPerServing:Int,
    val cuisine:String,
    val difficulty: String,
    val image: String,
    val ingredients: List<String>,
    val instructions:List<String>,
    val mealType:List<String>,
    val prepTimeMinutes:Int,
    val rating:Double,
    val reviewCount:Int,
    val servings: Int,
    val tags:List<String>,
    val userId:Int



)
