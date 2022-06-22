package com.example.noteapplication.presenter.screens.addnote

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import com.example.noteapplication.presenter.theme.font

@Composable
fun AddNoteScreen() {
    AddNoteScreenBody()
}

@Composable
fun AddNoteScreenBody() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxSize(),
        label = {
            Text(
                text = "Page Title",
                color = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.6f),
                fontWeight = FontWeight.Bold,
                fontFamily = font
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = NoteApplicationTheme.colors.bottomBar,
            textColor = NoteApplicationTheme.colors.primaryText,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = NoteApplicationTheme.colors.buttonColor
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PrevAddNoteScreen() {
    NoteApplicationTheme {
        AddNoteScreenBody()
    }
}