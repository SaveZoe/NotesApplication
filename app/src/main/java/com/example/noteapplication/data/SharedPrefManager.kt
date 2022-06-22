package com.example.noteapplication.data

import android.content.Context
import android.content.SharedPreferences

const val NAME = "shPref"

object SharedPrefManager {
    private lateinit var shPref: SharedPreferences

    fun init(context: Context) {
        shPref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    fun firstOpen() {
        shPref.edit().putBoolean(NAME, false).apply()
    }

    fun getFirstOpen() = shPref.getBoolean(NAME, true)
}