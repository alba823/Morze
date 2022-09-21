package com.example.morze.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import com.example.morze.ListenerBoolParam
import com.example.morze.utils.RecognitionTimer
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun Modifier.timedClick(
    timeInMillis: Long,
    enabled: Boolean,
    timer: RecognitionTimer,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClickResult: ListenerBoolParam,
    onInteraction: ListenerBoolParam
) = composed {
    var timeOfTouch = -1L
    LaunchedEffect(key1 = timeInMillis, key2 = interactionSource) {
        interactionSource.interactions
            .onEach { interaction: Interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        timer.startCountDown(false)
                        onInteraction(true)
                        timeOfTouch = System.currentTimeMillis()
                    }
                    is PressInteraction.Release -> {
                        timer.startCountDown(true)
                        onInteraction(false)
                        val currentTime = System.currentTimeMillis()
                        onClickResult(currentTime - timeOfTouch > timeInMillis)
                    }
                }

            }
            .launchIn(this)
    }

    Modifier.clickable(
        enabled = enabled,
        interactionSource = interactionSource,
        indication = rememberRipple(
            radius = 100.dp
        ),
        onClick = {}
    )
}