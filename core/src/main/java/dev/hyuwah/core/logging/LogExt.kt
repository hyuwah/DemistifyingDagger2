package dev.hyuwah.core.logging

import android.util.Log
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Any.identify(): String {
    return this.toString().replaceBeforeLast(".","")
}

private fun printCurrentTime(): String {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
}

suspend fun logCounterInterval(scopeName: String, source: String,  startTime: String = printCurrentTime()) {
    for (i in 1 .. 20) {
        Log.d("Coroutine", "$source|$scopeName|$startTime: $i")
        delay(1000)
    }
}