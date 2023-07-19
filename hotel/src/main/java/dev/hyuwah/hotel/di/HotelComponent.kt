package dev.hyuwah.hotel.di

import android.content.Context
import dagger.Component
import dev.hyuwah.core.di.CoreProvider
import dev.hyuwah.core.di.FeatureScope
import dev.hyuwah.core.di.coreProvider
import dev.hyuwah.hotel.HotelMainActivity
import dev.hyuwah.hotel_api.di.HotelProvider

@FeatureScope
@Component(
    modules = [
        HotelModule::class,
        HotelViewModelModule::class,
    ],
    dependencies = [CoreProvider::class]
)
interface HotelComponent : HotelProvider {

    companion object {
        fun injector(context: Context): HotelComponent {
            return DaggerHotelComponent.builder()
                .coreProvider(context.coreProvider())
                .build()
        }
    }

    fun inject(activity: HotelMainActivity)
}