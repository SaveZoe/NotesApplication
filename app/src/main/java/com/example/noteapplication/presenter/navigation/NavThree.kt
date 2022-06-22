package com.example.noteapplication.presenter.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.noteapplication.R

sealed class NavThree(val route: String, val icon: ImageVector, @StringRes val name: Int) {
    object Note : NavThree("home", Icons.Outlined.Description, R.string.Notes)
    object FirstStart : NavThree("first_open", Icons.Outlined.EditCalendar, R.string.Get_Started)
    object Search : NavThree("search", Icons.Default.Search, R.string.Search)
    object AddNote : NavThree("addNote", Icons.Default.Create, R.string.CreateNote)
    object Event : NavThree("Event", Icons.Outlined.EditCalendar, R.string.Event)
}