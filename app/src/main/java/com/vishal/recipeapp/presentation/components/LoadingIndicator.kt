package com.vishal.recipeapp.presentation.components

import android.icu.number.IntegerWidth
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.vishal.recipeapp.ui.theme.MyOrange

@Composable

fun LoadingIndicator(
    strokeWidth: Dp
){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        CircularProgressIndicator(color = MyOrange, strokeWidth =  strokeWidth )

    }
}