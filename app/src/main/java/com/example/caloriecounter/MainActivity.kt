package com.example.caloriecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.example.caloriecounter.ui.theme.CalorieCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieCounterTheme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var totalCalories by remember { mutableStateOf(Prefs.getCalories(context)) }
    var mealList by remember { mutableStateOf(listOf<Meal>()) }

    NavHost(navController, startDestination = "calorie") {
        composable("calorie") {
            CalorieCounterScreen(
                onAddMeal = { meal ->
                    totalCalories += meal.calories
                    Prefs.saveCalories(context, totalCalories)
                    mealList = mealList + meal
                },
                onGoToSummary = { navController.navigate("summary") },
                onGoToChart = { navController.navigate("chart") }
            )
        }
        composable("summary") {
            SummaryScreen(totalCalories) {
                navController.popBackStack()
            }
        }
        composable("chart") {
            ChartScreen(mealList) {
                navController.popBackStack()
            }
        }
    }
}
