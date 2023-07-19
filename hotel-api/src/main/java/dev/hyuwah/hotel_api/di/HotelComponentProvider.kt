package dev.hyuwah.hotel_api.di

import android.content.Context

interface HotelComponentProvider {
    fun provideHotel(): HotelProvider
}

fun Context.hotelProvider() = (this.applicationContext as HotelComponentProvider).provideHotel()