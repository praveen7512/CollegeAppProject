package com.example.collegeappproject.models

import androidx.compose.ui.graphics.vector.ImageVector


//This is the data class for bottom Navigation item
data class BottomNavItem(
    val name :String,
    val icon :ImageVector,
    val route :String
)
