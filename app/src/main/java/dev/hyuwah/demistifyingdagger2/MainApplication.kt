package dev.hyuwah.demistifyingdagger2

import android.app.Application
import dev.hyuwah.core.di.CoreComponentProvider
import dev.hyuwah.core.di.CoreProvider
import dev.hyuwah.core.di.DaggerCoreComponent
import dev.hyuwah.demistifyingdagger2.di.AppProvider
import dev.hyuwah.demistifyingdagger2.di.DaggerAppComponent
import dev.hyuwah.hotel.di.DaggerHotelComponent
import dev.hyuwah.hotel_api.di.HotelComponentProvider
import dev.hyuwah.hotel_api.di.HotelProvider

class MainApplication : Application(),
    CoreComponentProvider,
    HotelComponentProvider {

    lateinit var appProvider: AppProvider
        private set

    override fun provideCore(): CoreProvider = appProvider

    override fun provideHotel(): HotelProvider =
        DaggerHotelComponent.builder().coreProvider(appProvider).build()

    override fun onCreate() {
        super.onCreate()
        appProvider = DaggerAppComponent.builder()
            .coreProvider(DaggerCoreComponent.factory().create(this))
            .build()
    }
}