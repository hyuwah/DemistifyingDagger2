package dev.hyuwah.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoroutineModule::class,
        NetworkModule::class,
    ]
)
interface CoreComponent : CoreProvider {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance appContext: Context,
        ): CoreComponent
    }
}