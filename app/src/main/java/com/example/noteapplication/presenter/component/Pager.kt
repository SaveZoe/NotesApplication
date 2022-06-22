package com.example.noteapplication.presenter.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyPager(pagerState: PagerState) {
    HorizontalPagerIndicator(
        pagerState = pagerState,
        activeColor = NoteApplicationTheme.colors.carouselActive,
        inactiveColor = NoteApplicationTheme.colors.carouselInactive,
        indicatorWidth = 110.dp,
        indicatorHeight = 4.56.dp,
        spacing = 0.dp,
        modifier = Modifier
            .padding(top = 30.dp)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    )
}