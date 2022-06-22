package com.example.noteapplication.presenter.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val lightColorPalette = NoteApplicationColors(
    primaryBackground = primaryBackground,
    bottomBar = bottomBar,
    primaryText = primaryText,
    buttonColor = buttonColor,
    carouselActive = carouselActive,
    carouselInactive = carouselInactive,
    deleteButton = deleteButton,
    secondaryButtonColor = secondaryButtonColor,
    isDark = false
)

@Composable
fun NoteApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) lightColorPalette else lightColorPalette

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }
    ProvideNoteColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            content = content
        )
    }
}

object NoteApplicationTheme {
    val colors: NoteApplicationColors
        @Composable
        get() = LocalNoteColors.current
}

@Stable
class NoteApplicationColors(
    primaryBackground: Color,
    bottomBar: Color,
    primaryText: Color,
    buttonColor: Color,
    carouselActive: Color,
    carouselInactive: Color,
    deleteButton: Color,
    isDark: Boolean,
    secondaryButtonColor: Color
) {
    var primaryBackground by mutableStateOf(primaryBackground)
        private set
    var bottomBar by mutableStateOf(bottomBar)
        private set
    var primaryText by mutableStateOf(primaryText)
        private set
    var buttonColor by mutableStateOf(buttonColor)
        private set
    var carouselActive by mutableStateOf(carouselActive)
        private set
    var carouselInactive by mutableStateOf(carouselInactive)
        private set
    var deleteButton by mutableStateOf(deleteButton)
        private set
    private var isDark by mutableStateOf(isDark)
    var secondaryButtonColor by mutableStateOf(secondaryButtonColor)
        private set

    fun update(other: NoteApplicationColors) {
        primaryBackground = other.primaryBackground
        bottomBar = other.bottomBar
        primaryText = other.primaryText
        buttonColor = other.buttonColor
        carouselActive = other.carouselActive
        carouselInactive = other.carouselInactive
        deleteButton = other.deleteButton
        isDark = other.isDark
        secondaryButtonColor = other.secondaryButtonColor
    }

    fun copy(): NoteApplicationColors = NoteApplicationColors(
        primaryBackground = primaryBackground,
        bottomBar = bottomBar,
        primaryText = primaryText,
        buttonColor = buttonColor,
        carouselActive = carouselActive,
        carouselInactive = carouselInactive,
        deleteButton = deleteButton,
        secondaryButtonColor = secondaryButtonColor,
        isDark = isDark
    )
}

@Composable
fun ProvideNoteColors(
    colors: NoteApplicationColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }
    colors.update(colors)
    CompositionLocalProvider(LocalNoteColors provides colorPalette, content = content)
}

private val LocalNoteColors = staticCompositionLocalOf<NoteApplicationColors> {
    error("No LocalNoteColors provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)


