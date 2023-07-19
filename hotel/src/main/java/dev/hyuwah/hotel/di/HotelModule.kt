package dev.hyuwah.hotel.di

import dagger.Binds
import dagger.Module
import dev.hyuwah.hotel.service.HotelInternalService
import dev.hyuwah.hotel.service.HotelInternalServiceImpl
import dev.hyuwah.hotel.service.HotelServiceImpl
import dev.hyuwah.hotel_api.service.HotelService

@Module
abstract class HotelModule {
    @Binds
    abstract fun bindHotelService(impl: HotelServiceImpl): HotelService

    @Binds
    abstract fun bindHotelInternalService(impl: HotelInternalServiceImpl): HotelInternalService

}