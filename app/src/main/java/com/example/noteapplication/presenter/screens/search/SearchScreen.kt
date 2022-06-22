package com.example.noteapplication.presenter.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapplication.presenter.component.SearchEditText
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun SearchScreen() {
    SearchScreenBody()
}

@Composable
fun SearchScreenBody() {
    Column(modifier = Modifier.padding(16.dp)) {
        SearchEditText()
        Text(text = "Recent Searches", modifier = Modifier.padding(bottom = 16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            backgroundColor = NoteApplicationTheme.colors.primaryBackground,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "No recent searches to display",
                    fontStyle = FontStyle.Italic,
                    color = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevSearchScreen() {
    NoteApplicationTheme {
        SearchScreenBody()
    }
}