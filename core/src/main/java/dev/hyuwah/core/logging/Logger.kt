package dev.hyuwah.core.logging

import android.util.Log
import javax.inject.Inject

private const val TAG = "Logger"

class Logger @Inject constructor() {
    fun log() {
        Log.d(TAG, "Logging something")
    }
}