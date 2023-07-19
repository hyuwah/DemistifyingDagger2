package dev.hyuwah.core.di

import android.util.Log
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class Dispatcher(val dispatcher: AppDispatcher)

enum class AppDispatcher {
    Default, Main, IO
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

@Module
object CoroutineModule {

    @Dispatcher(AppDispatcher.Default)
    @Singleton
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Dispatcher(AppDispatcher.Main)
    @Singleton
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Dispatcher(AppDispatcher.IO)
    @Singleton
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @ApplicationScope
    @Singleton
    @Provides
    fun provideApplicationScope(
        @Dispatcher(AppDispatcher.Default) dispatcher: CoroutineDispatcher
    ): CoroutineScope {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.e("Coroutine", "AppScopeException: $throwable")
        }
        return CoroutineScope(SupervisorJob() + dispatcher + exceptionHandler)
    }

}