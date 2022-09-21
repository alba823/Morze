package com.example.morze

import android.media.MediaPlayer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.morze.utils.CodeMapUS
import com.example.morze.utils.Constants.LETTER_RECOGNIZE_DURATION
import com.example.morze.utils.RecognitionTimer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mediaPlayer: MediaPlayer
) : ViewModel() {
    val timer: RecognitionTimer = RecognitionTimer(LETTER_RECOGNIZE_DURATION, viewModelScope)

    private val _decodedText = mutableStateOf("")
    val decodedText: State<String> = _decodedText

    private val _encodedText = mutableStateOf("")
    val encodedText: State<String> = _encodedText

    private val _inputText = mutableStateOf("")
    val inputText: State<String> = _inputText

    private val charCode = mutableListOf<Boolean>()

    init {
        mediaPlayer.start()
        mediaPlayer.pause()
        viewModelScope.launch {
            timer.characterTimedOut.collectLatest {
                if (charCode.isNotEmpty()) {
                    decodeCharacter()
                }
            }
        }
    }

    private fun decodeCharacter() {
        CodeMapUS[charCode]?.let { decodedChar ->
            _decodedText.value = _decodedText.value.plus(decodedChar)
        }
        charCode.clear()
    }

    fun encodeCharacter(text: String) {
        _encodedText.value = if (text.isNotBlank()) {
            text.lowercase().map { char ->
                val pair = CodeMapUS
                    .filter { it.value == char }
                    .takeIf { it.isNotEmpty() }

                encodeCharacter(pair?.entries?.first()?.key)
            }.joinToString(" ")
        } else ""
        _inputText.value = text
    }

    private fun encodeCharacter(list: List<Boolean>?): String =
        list?.joinToString("") { if (it) "-" else "." } ?: ""


    fun startBeep() {
        mediaPlayer.start()
    }

    fun stopBeep() {
        mediaPlayer.pause()
        mediaPlayer.seekTo(1000)
    }

    fun onCodeInput(isLongClick: Boolean) {
        charCode.add(isLongClick)
    }

    fun reset() {
        _decodedText.value = ""
    }

    fun onClearText() {
        _encodedText.value = ""
        _inputText.value = ""
    }

    fun onPlay() {
        viewModelScope.launch {
            encodedText.value.forEach { char ->
                when (char) {
                    '-' -> {
                        startBeep()
                        delay(LONG_BEEP_DURATION)
                        stopBeep()
                        delay(AFTER_BEEP_DURATION)
                    }
                    '.' -> {
                        startBeep()
                        delay(SHORT_BEEP_DURATION)
                        stopBeep()
                        delay(AFTER_BEEP_DURATION)
                    }
                    else -> {
                        delay(DELAY_DURATION)
                    }
                }
            }
        }
    }
}

private const val LONG_BEEP_DURATION = 500L
private const val SHORT_BEEP_DURATION = 300L
private const val AFTER_BEEP_DURATION = 150L
private const val DELAY_DURATION = 800L