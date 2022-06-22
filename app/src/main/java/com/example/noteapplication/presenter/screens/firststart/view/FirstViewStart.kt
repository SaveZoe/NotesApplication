package com.example.noteapplication.presenter.screens.firststart.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.noteapplication.R
import com.example.noteapplication.presenter.component.MyPager
import com.example.noteapplication.presenter.theme.NoteApplicationTheme
import com.example.noteapplication.presenter.theme.font
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun FirstViewStart(
    clickSkip: suspend () -> Unit,
    pagerState: @Composable () -> Unit,
    clickNext: suspend () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val button = createRef()
        val coroutineScope = rememberCoroutineScope()
        val skip: () -> Unit = {
            coroutineScope.launch {
                clickSkip.invoke()
            }
        }
        val next: () -> Unit = {
            coroutineScope.launch {
                clickNext.invoke()
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(color = NoteApplicationTheme.colors.primaryBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 22.01.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = { skip.invoke() },
                    colors = ButtonDefaults.textButtonColors(contentColor = NoteApplicationTheme.colors.buttonColor)
                ) {
                    Text(text = stringResource(R.string.Skip))
                }
            }

            Image(
                painter = painterResource(id = R.drawable.clip_1060),
                contentDescription = null,
                modifier = Modifier
                    .padding(24.dp)
                    .requiredSize(342.dp)
            )

            Card(
                modifier = Modifier
                    .height(398.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp, 20.dp),
                backgroundColor = NoteApplicationTheme.colors.bottomBar,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        pagerState.invoke()
                    }
                    Text(
                        text = stringResource(R.string.manage_notes),
                        modifier = Modifier.padding(
                            top = 30.dp,
                            bottom = 5.dp,
                            start = 50.dp,
                            end = 50.dp
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = NoteApplicationTheme.colors.primaryText,
                        textAlign = TextAlign.Center,
                        fontFamily = font
                    )
                    Text(
                        text = stringResource(R.string.easy_way_manage),
                        fontSize = 15.sp,
                        color = NoteApplicationTheme.colors.primaryText,
                        fontFamily = font,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 30.dp)
                    )
                }
            }
        }
        Button(
            onClick = { next.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 25.dp)
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = NoteApplicationTheme.colors.buttonColor,
                contentColor = NoteApplicationTheme.colors.primaryBackground
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(text = stringResource(R.string.Next))
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun PrevFirstViewStart() {
    val pagerState = rememberPagerState(0)
    NoteApplicationTheme {
        FirstViewStart(
            clickSkip = {},
            pagerState = { MyPager(pagerState = pagerState) }
        ) {}
    }
}