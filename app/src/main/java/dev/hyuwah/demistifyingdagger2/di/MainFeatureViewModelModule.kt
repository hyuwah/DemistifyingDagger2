package dev.hyuwah.demistifyingdagger2.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.hyuwah.core.di.ViewModelFactoryModule
import dev.hyuwah.core.di.ViewModelKey
import dev.hyuwah.demistifyingdagger2.feature.MainViewModel

@Module
interface MainFeatureViewModelModule: ViewModelFactoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(impl: MainViewModel): ViewModel
}