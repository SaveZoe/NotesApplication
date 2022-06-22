package com.example.noteapplication.presenter.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun Table() {
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FilterNote()
            FilterNote()
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FilterNote()
            FilterNote()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevTable() {
    NoteApplicationTheme {
        Table()
    }
}