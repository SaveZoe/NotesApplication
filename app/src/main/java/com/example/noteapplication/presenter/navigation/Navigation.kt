package com.example.noteapplication.presenter.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.noteapplication.data.SharedPrefManager
import com.example.noteapplication.presenter.component.MyBottomBar
import com.example.noteapplication.presenter.component.MyTopBar
import com.example.noteapplication.presenter.screens.addnote.AddNoteScreen
import com.example.noteapplication.presenter.screens.event.EventScreen
import com.example.noteapplication.presenter.screens.firststart.FirstStart
import com.example.noteapplication.presenter.screens.notescreen.NoteScreen
import com.example.noteapplication.presenter.screens.search.SearchScreen
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun Navigation(navController: NavHostController) {
    val state = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showBar by rememberSaveable { mutableStateOf(true) }
    showBar = when (navBackStackEntry?.destination?.route) {
        NavThree.FirstStart.route -> false
        else -> true
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = state,
        topBar = {
            if (showBar) {
                MyTopBar()
            }
        },
        bottomBar = {
            if (showBar) {
                MyBottomBar(navController = navController)
            }
        },
        backgroundColor = NoteApplicationTheme.colors.bottomBar
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (SharedPrefManager.getFirstOpen()) NavThree.FirstStart.route else NavThree.Note.route
        ) {
            composable(NavThree.FirstStart.route) { FirstStart(navController = navController) }
            composable(NavThree.Note.route) { NoteScreen(modifier = Modifier.padding(innerPadding)) }
            composable(NavThree.AddNote.route) { AddNoteScreen() }
            composable(NavThree.Search.route) { SearchScreen() }
            composable(NavThree.Event.route) { EventScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevNavigation() {
    NoteApplicationTheme {
        Navigation(navController = rememberNavController())
    }
}