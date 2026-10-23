package com.vishal.recipeapp.data.remote.ktorclient

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient{

    val client = HttpClient(Android){
        install(ContentNegotiation){
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }



    }

   //const val BASE_URL = "https://dummyjson.com/"
   // const val RECIPE = "$BASE_URL/recipes"
}

// ktor client ye internet se communication network call kre ga request send or receive data response
