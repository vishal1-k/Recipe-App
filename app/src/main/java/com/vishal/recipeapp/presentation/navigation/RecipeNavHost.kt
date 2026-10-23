package com.vishal.recipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.vishal.recipeapp.presentation.screens.HomeScreen
import com.vishal.recipeapp.presentation.screens.recipe_details.RecipeDetailScreen


@Composable
fun RecipeNavHost(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ){
        composable<HomeRoute> {
            HomeScreen(
                onRecipeClick = { id ->
                    navController.navigate(RecipeDetailRoute(id))

                }
            )
        }

        composable<RecipeDetailRoute> { backStackEntry ->

            val detailRoute = backStackEntry.toRoute<RecipeDetailRoute>()

            RecipeDetailScreen(
                recipeId = detailRoute.recipeId,
                onBack = {navController.popBackStack()}
            )

        }
    }

}