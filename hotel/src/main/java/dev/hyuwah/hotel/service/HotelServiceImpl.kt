package dev.hyuwah.hotel.service

import android.util.Log
import dev.hyuwah.core.di.FeatureScope
import dev.hyuwah.core.logging.identify
import dev.hyuwah.core.network.NetworkClient
import dev.hyuwah.hotel_api.service.HotelService
import javax.inject.Inject

private const val TAG = "HotelServiceImpl"
@FeatureScope
class HotelServiceImpl @Inject constructor(
    private val networkClient: NetworkClient
): HotelService {
    override fun getHotel() {
        Log.d(TAG, "${this.identify()} getHotel using client:${networkClient.identify()}")
    }
}