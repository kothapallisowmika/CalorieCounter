package com.example.caloriecounter

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

@Composable
fun ChartScreen(meals: List<Meal>, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meal Calorie Chart",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))

        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp), // smaller height for better fit
            factory = { context ->
                BarChart(context).apply {
                    val entries = meals.mapIndexed { index, meal ->
                        BarEntry(index.toFloat(), meal.calories.toFloat())
                    }

                    val dataSet = BarDataSet(entries, "Calories")
                    dataSet.color = Color.rgb(100, 149, 237) // cornflower blue
                    dataSet.valueTextColor = Color.BLACK
                    dataSet.valueTextSize = 12f

                    val barData = BarData(dataSet)
                    data = barData

                    xAxis.valueFormatter = IndexAxisValueFormatter(meals.map { it.name })
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.setDrawGridLines(false)
                    xAxis.granularity = 1f
                    xAxis.labelRotationAngle = -45f
                    axisRight.isEnabled = false
                    axisLeft.setDrawGridLines(false)

                    description.isEnabled = false
                    legend.isEnabled = false
                    animateY(1000)
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}
