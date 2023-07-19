package dev.hyuwah.core.di

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

/**
 * MainApplication will extend this interface, so feature & lib module can get access to
 * CoreComponent (as CoreProvider) which is bound to the AppComponent inside MainApplication
 */
interface CoreComponentProvider {
    fun provideCore(): CoreProvider
}

fun Activity.coreProvider() = (this.application as CoreComponentProvider).provideCore()
fun Fragment.coreProvider() = (this.requireContext().applicationContext as CoreComponentProvider).provideCore()
fun Context.coreProvider() = (this.applicationContext as CoreComponentProvider).provideCore()