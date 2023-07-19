package dev.hyuwah.demistifyingdagger2.di

import dagger.Component
import dev.hyuwah.core.di.CoreProvider
import dev.hyuwah.hotel_api.di.HotelProvider
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreProvider::class,
    ]
)
interface AppComponent: AppProvider {

}