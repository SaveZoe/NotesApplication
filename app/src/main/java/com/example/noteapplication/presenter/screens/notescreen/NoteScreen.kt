package com.example.noteapplication.presenter.screens.notescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapplication.presenter.component.MyNote
import com.example.noteapplication.presenter.component.SearchEditText
import com.example.noteapplication.presenter.component.Table
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun NoteScreen(modifier: Modifier) {
    NoteScreenBody(modifier = modifier)
}

@Composable
fun NoteScreenBody(modifier: Modifier) {
    var deleteButtonShow by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        SearchEditText()
        Table()
        Text(
            text = "Recent Notes",
            modifier = Modifier.padding(22.dp),
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
        LazyColumn() {
            items(1) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            deleteButtonShow = !deleteButtonShow
                        }
                ) {
                    MyNote(
                        modifier = Modifier
                            .size(width = 168.dp, height = 198.dp)
                    )
                    MyNote(
                        modifier = Modifier
                            .size(width = 168.dp, height = 198.dp)
                    )
                }
                if (deleteButtonShow) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(8.dp),
                        backgroundColor = NoteApplicationTheme.colors.deleteButton
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }
                }
            }
            items(2) {
                MyNote(
                    modifier = Modifier
                        .fillMaxWidth().padding(8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevNoteScreenBody() {
    NoteApplicationTheme {
        NoteScreenBody(Modifier)
    }
}