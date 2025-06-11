package com.example.caloriecounter

import android.content.Context

object Prefs {
    private const val PREFS_NAME = "calorie_prefs"
    private const val KEY_TOTAL_CALORIES = "total_calories"

    fun saveCalories(context: Context, calories: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putInt(KEY_TOTAL_CALORIES, calories).apply()
    }

    fun getCalories(context: Context): Int {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getInt(KEY_TOTAL_CALORIES, 0)
    }
}
