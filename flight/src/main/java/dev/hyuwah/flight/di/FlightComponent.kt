package dev.hyuwah.flight.di

import android.content.Context
import dagger.Component
import dev.hyuwah.core.di.CoreProvider
import dev.hyuwah.core.di.FeatureScope
import dev.hyuwah.core.di.coreProvider
import dev.hyuwah.flight.FlightMainActivity
import dev.hyuwah.hotel_api.di.HotelProvider
import dev.hyuwah.hotel_api.di.hotelProvider

@FeatureScope
@Component(
    dependencies = [CoreProvider::class, HotelProvider::class]
)
interface FlightComponent {

    companion object {
        fun injector(context: Context): FlightComponent {
            return DaggerFlightComponent.builder()
                .coreProvider(context.coreProvider())
                .hotelProvider(context.hotelProvider())
                .build()
        }
    }

    fun inject(activity: FlightMainActivity)
}