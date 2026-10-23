package com.vishal.recipeapp.data.remote.recipeapiservice

import com.vishal.recipeapp.data.remote.dto.AddRecipeRequest
import com.vishal.recipeapp.data.remote.dto.RecipeResponse
import com.vishal.recipeapp.data.remote.dto.RecipesDTO
import com.vishal.recipeapp.data.remote.ktorclient.KtorClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType


class RecipeApiService (private val client: HttpClient){

    suspend fun getAllRecipes(): RecipeResponse{
        return client.get(urlString = "${KtorClient.BASE_URL}recipes").body()
    }

    suspend fun getRecipeByID(id:Int): RecipesDTO{
        return client.get("${KtorClient.BASE_URL}recipes/$id").body()
    }

    suspend fun addRecipe(request: AddRecipeRequest){
        client.post("${KtorClient.BASE_URL}recipes/add"){
            contentType(ContentType.Application.Json)
            setBody(request)
        }
    }
}

// api service ek class hai jis me hum api se related sare function likhte hai
// like data fetch krna , all recipe data ,single recipe data etc

// body function json data ko convert krne ka kaam krta hai