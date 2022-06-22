package com.example.noteapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.noteapplication.data.SharedPrefManager
import com.example.noteapplication.presenter.navigation.Navigation
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPrefManager.init(this)
        setContent {
            NoteApplicationTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}