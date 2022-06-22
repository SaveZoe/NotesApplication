package com.example.noteapplication.presenter.screens.firststart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.noteapplication.data.SharedPrefManager.firstOpen
import com.example.noteapplication.presenter.component.MyPager
import com.example.noteapplication.presenter.navigation.NavThree
import com.example.noteapplication.presenter.screens.firststart.view.FirstViewStart
import com.example.noteapplication.presenter.screens.firststart.view.SecondViewStart
import com.example.noteapplication.presenter.screens.firststart.view.ThirdViewStart
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FirstStart(
    navController: NavController
) {
    val pagerState = rememberPagerState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = NoteApplicationTheme.colors.primaryBackground,
    ) {
        HorizontalPager(count = 3, state = pagerState) { page ->
            when (page) {
                0 -> FirstViewStart(
                    clickSkip = suspend { pagerState.scrollToPage(2) },
                    pagerState = { MyPager(pagerState = pagerState) },
                    clickNext = suspend { pagerState.animateScrollToPage(1) }
                )
                1 -> SecondViewStart(
                    pagerState = { MyPager(pagerState = pagerState) },
                    clickNext = suspend { pagerState.animateScrollToPage(2) },
                    clickSkip = suspend { pagerState.animateScrollToPage(2) },
                    clickBack = suspend { pagerState.animateScrollToPage(0) }
                )
                2 -> ThirdViewStart(
                    pagerState = { MyPager(pagerState = pagerState) },
                    clickBack = suspend { pagerState.animateScrollToPage(1) }
                ) {
                    navController.popBackStack()
                    navController.navigate(NavThree.Note.route)
                    firstOpen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevFirstStart() {
    NoteApplicationTheme {
        FirstStart(rememberNavController())
    }
}


