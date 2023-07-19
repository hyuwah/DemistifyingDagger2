package dev.hyuwah.core.network

import android.util.Log

private const val TAG = "NetworkClient"

// Third party lib, cannot use constructor @Inject
class NetworkClient {
    fun fetch() {
        Log.d(TAG, "fetching some data")
    }
}