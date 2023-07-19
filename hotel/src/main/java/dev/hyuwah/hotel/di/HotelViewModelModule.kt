package dev.hyuwah.hotel.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.hyuwah.core.di.ViewModelFactoryModule
import dev.hyuwah.core.di.ViewModelKey
import dev.hyuwah.hotel.HotelMainViewModel

@Module
interface HotelViewModelModule : ViewModelFactoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(HotelMainViewModel::class)
    fun bindHotelMainViewModel(impl: HotelMainViewModel): ViewModel
}