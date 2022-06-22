package com.example.noteapplication.presenter.screens.event

import android.widget.CalendarView
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun EventScreen() {
    EventScreenBody()
}

@Composable
fun EventScreenBody() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AndroidView(factory = { CalendarView(it) })

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.3f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Sunday ", fontWeight = FontWeight.Bold)
            Text(
                text = "22 december",
                color = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.6f)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            backgroundColor = NoteApplicationTheme.colors.secondaryButtonColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row() {
                    Icon(
                        imageVector = Icons.Outlined.AddCircle,
                        contentDescription = null,
                        tint = NoteApplicationTheme.colors.primaryText.copy(alpha = 0.6f)
                    )
                    Text(text = "Create New Event", modifier = Modifier.padding(start = 16.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevEventScreen() {
    NoteApplicationTheme {
        EventScreenBody()
    }
}