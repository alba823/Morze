package com.example.morze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.morze.extensions.timedClick
import com.example.morze.ui.theme.AppleGreen
import com.example.morze.ui.theme.Emerald
import com.example.morze.ui.theme.MorzeTheme
import com.example.morze.ui.theme.Tomato
import com.example.morze.utils.Constants.LONG_CLICK_DURATION
import com.example.morze.utils.RecognitionTimer
import dagger.hilt.android.AndroidEntryPoint

typealias Listener = () -> Unit
typealias ListenerStringParam = (String) -> Unit
typealias ListenerBoolParam = (Boolean) -> Unit

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MorzeTheme {
                val viewModel: MainViewModel = hiltViewModel()
                var currentScreen by remember { mutableStateOf(Screen.Decoder) }

                when (currentScreen) {
                    Screen.Decoder -> {
                        Decoder(
                            text = viewModel.decodedText.value,
                            timer = viewModel.timer,
                            onClickResult = viewModel::onCodeInput,
                            onScreenChange = { currentScreen = Screen.Encoder },
                            onClearText = viewModel::reset,
                            onInteraction = { isStarted ->
                                if (isStarted) {
                                    viewModel.startBeep()
                                } else {
                                    viewModel.stopBeep()
                                }
                            }
                        )
                    }
                    Screen.Encoder -> {
                        Encoder(
                            inputText = viewModel.inputText.value,
                            outputText = viewModel.encodedText.value,
                            onTextChange = viewModel::encodeCharacter,
                            onScreenChange = { currentScreen = Screen.Decoder },
                            onPlayClick = viewModel::onPlay,
                            onClearText = viewModel::onClearText
                        )
                    }
                }
            }
        }
    }


}

@ExperimentalFoundationApi
@Composable
fun Decoder(
    text: String,
    timer: RecognitionTimer,
    onClickResult: ListenerBoolParam,
    onScreenChange: Listener,
    onClearText: Listener,
    onInteraction: ListenerBoolParam
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .combinedClickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {},
                onDoubleClick = onScreenChange,
                onLongClick = onClearText,
            ),
        color = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body1
            )
            Surface(
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.BottomCenter)
                    .padding(24.dp)
                    .timedClick(
                        enabled = true,
                        timer = timer,
                        timeInMillis = LONG_CLICK_DURATION,
                        onClickResult = onClickResult,
                        onInteraction = onInteraction
                    ),
                color = Tomato,
                shape = RoundedCornerShape(100),
                content = {}
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Encoder(
    inputText: String,
    outputText: String,
    onTextChange: ListenerStringParam,
    onScreenChange: Listener,
    onPlayClick: Listener,
    onClearText: Listener
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .combinedClickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {},
                onDoubleClick = onScreenChange,
                onLongClick = onClearText,
            ),
        color = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 24.dp)
        ) {
            TextField(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                value = inputText,
                onValueChange = onTextChange,
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = outputText,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1.copy(fontSize = 28.sp)
            )
            Surface(
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.BottomCenter)
                    .padding(24.dp)
                    .clickable(
                        onClick = onPlayClick
                    ),
                color = Emerald,
                shape = RoundedCornerShape(100),
                content = {}
            )
        }
    }
}

enum class Screen {
    Decoder, Encoder
}