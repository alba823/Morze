package com.example.morze.utils

import android.os.CountDownTimer
import android.text.format.DateUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RecognitionTimer(
    duration: Long,
    private val scope: CoroutineScope
) : CountDownTimer(duration, DateUtils.SECOND_IN_MILLIS) {

    private val _characterTimedOut = Channel<Unit>()
    val characterTimedOut = _characterTimedOut.receiveAsFlow()

    private var shouldDecode: Boolean = false

    fun startCountDown(decodeOnFinish: Boolean) {
        start()
        shouldDecode = decodeOnFinish
    }

    override fun onTick(millisUntilFinished: Long) {}

    override fun onFinish() {
        if (shouldDecode) {
            scope.launch {
                _characterTimedOut.send(Unit)
            }
        }
    }
}
