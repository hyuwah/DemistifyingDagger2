package dev.hyuwah.core.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dev.hyuwah.core.network.NetworkClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

/**
 * Pure interface, exposing collection of core objects, including appContext
 * Real/Dagger CoreComponent will extend this interface
 */
interface CoreProvider {

    val appContext: Context

    @Dispatcher(AppDispatcher.Default)
    fun exposeDefaultDispatcher(): CoroutineDispatcher

    @Dispatcher(AppDispatcher.Main)
    fun exposeMainDispatcher(): CoroutineDispatcher

    @Dispatcher(AppDispatcher.IO)
    fun exposeIoDispatcher(): CoroutineDispatcher

    @ApplicationScope
    fun exposeApplicationScope(): CoroutineScope

    fun exposeNetworkClient(): NetworkClient
}