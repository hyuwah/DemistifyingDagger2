package dev.hyuwah.core.di

import dagger.Module
import dagger.Provides
import dev.hyuwah.core.network.NetworkClient
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkClient(): NetworkClient {
        return NetworkClient()
    }

}