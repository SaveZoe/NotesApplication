package com.example.noteapplication.presenter.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapplication.R
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import com.example.noteapplication.presenter.theme.Shapes

@Composable
fun FilterNote() {
    Card(
        modifier = Modifier
            .size(width = 168.dp, height = 50.dp),
        shape = Shapes.medium,
        backgroundColor = NoteApplicationTheme.colors.primaryBackground
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(start = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.subtract),
                contentDescription = null,
                Modifier.size(32.dp)
            )
            Text(text = "All Notes", modifier = Modifier.padding(start = 16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevFilterNote() {
    NoteApplicationTheme {
        FilterNote()
    }
}