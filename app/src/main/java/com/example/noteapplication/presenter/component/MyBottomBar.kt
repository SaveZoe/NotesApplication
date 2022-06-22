package com.example.noteapplication.presenter.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.noteapplication.presenter.navigation.NavThree
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun MyBottomBar(navController: NavController) {
    val screenItems = listOf(
        NavThree.Note,
        NavThree.Event,
        NavThree.Search,
        NavThree.AddNote
    )
    BottomNavigation(
        backgroundColor = NoteApplicationTheme.colors.bottomBar
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screenItems.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = { Text(text = stringResource(id = screen.name)) }
            )
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0XFFFFFFFF)
@Composable
fun PrevMyBottomBar() {
    NoteApplicationTheme {
        val navigation = rememberNavController()
        MyBottomBar(navigation)
    }
}