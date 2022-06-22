package com.example.noteapplication.presenter.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun MyNote(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = NoteApplicationTheme.colors.primaryBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Getting Started", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                color = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.2f)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.\n" +
                        "Nisi, consectetur\n" +
                        "\n" +
                        "elementum."
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevMyNote() {
    NoteApplicationTheme {
        MyNote()
    }
}