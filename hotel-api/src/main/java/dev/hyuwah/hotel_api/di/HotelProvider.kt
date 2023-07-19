package dev.hyuwah.hotel_api.di

import dev.hyuwah.hotel_api.service.HotelService

/**
 * Pure interface, this expose hotel related object that will be used outside hotel feature module
 * Real/Dagger HotelComponent will extend this interface.
 * Actually, the feature module that depends on this interface will refer to the same HotelComponent
 * that's used internally by hotel feature module, but it'll be restricted to things that are exposed here
 */
interface HotelProvider {
    fun exposeHotelService(): HotelService
}