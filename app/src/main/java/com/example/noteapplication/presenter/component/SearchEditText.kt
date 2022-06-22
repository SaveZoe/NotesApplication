package com.example.noteapplication.presenter.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import com.example.noteapplication.presenter.theme.Shapes

@Composable
fun SearchEditText() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = "Search",
                fontSize = 17.sp,
                color = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.4f)
            )
        },
        shape = Shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp, vertical = 16.dp),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = NoteApplicationTheme.colors.primaryBackground,
            cursorColor = NoteApplicationTheme.colors.buttonColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PrevSearchEditText() {
    NoteApplicationTheme {
        SearchEditText()
    }
}