package com.example.noteapplication.presenter.screens.firststart.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
fun ThirdViewStart(
    pagerState: @Composable () -> Unit,
    clickBack: suspend () -> Unit,
    clickStart: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val button = createRef()
        val coroutine = rememberCoroutineScope()
        val back: () -> Unit = {
            coroutine.launch {
                clickBack.invoke()
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = NoteApplicationTheme.colors.primaryBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 22.dp)
            ) {
                TextButton(
                    onClick = { back.invoke() },
                    colors = ButtonDefaults.textButtonColors(contentColor = NoteApplicationTheme.colors.buttonColor)
                ) {
                    Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null)
                    Text(
                        text = stringResource(R.string.Back),
                        fontSize = 14.sp,
                        fontFamily = font,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.clip_1026),
                contentDescription = null,
                modifier = Modifier
                    .padding(24.dp)
                    .size(342.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(398.dp),
                shape = RoundedCornerShape(20.dp, 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = NoteApplicationTheme.colors.bottomBar)
                ) {
                    pagerState.invoke()
                    Text(
                        text = stringResource(R.string.CreateCard),
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
                        text = stringResource(R.string.MakingContent),
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
            onClick = { clickStart.invoke() },
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
            Text(text = stringResource(R.string.Get_Started))
        }
    }
}


@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PrevThirdViewStart() {
    val pager = rememberPagerState()
    NoteApplicationTheme {
        ThirdViewStart(pagerState = { MyPager(pagerState = pager) }, {}) {}
    }
}