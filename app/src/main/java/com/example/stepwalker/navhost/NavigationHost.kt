package com.example.stepwalker.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.FirstBaseline
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stepwalker.screens.FirstScreen
import com.example.stepwalker.screens.ResultScreen
import com.example.stepwalker.screens.StatisticsScreen

@Composable
fun NavigationHosting(navController: NavHostController = rememberNavController()){
    NavHost(navController = navController, startDestination = "profile"){
        composable("profile"){ FirstScreen(navController)}
        composable("result"){ ResultScreen(navController)}
        composable("statistics"){ StatisticsScreen(navController)}
    }
}