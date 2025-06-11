package com.example.caloriecounter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SummaryScreen(totalCalories: Int, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Total Calories Consumed", style = MaterialTheme.typography.headlineMedium)
        Text("$totalCalories kcal", style = MaterialTheme.typography.headlineSmall)

        Button(onClick = onBack) {
            Text("Back to Add More")
        }
    }
}
