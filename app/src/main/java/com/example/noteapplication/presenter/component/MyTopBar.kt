package com.example.noteapplication.presenter.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Pending
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.noteapplication.R
import com.example.noteapplication.presenter.theme.NoteApplicationTheme

@Composable
fun MyTopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = NoteApplicationTheme.colors.bottomBar
    ) {
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column() {
                    Text(text = "22 December, 2021", fontSize = 13.sp)
                    Text(text = stringResource(id = R.string.Notes))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.Pending, contentDescription = null)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevMyTopBar() {
    NoteApplicationTheme {
        MyTopBar()
    }
}