package dev.hyuwah.hotel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hyuwah.core.di.ApplicationScope
import dev.hyuwah.core.di.FeatureScope
import dev.hyuwah.core.logging.identify
import dev.hyuwah.core.logging.logCounterInterval
import dev.hyuwah.hotel_api.service.HotelService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HotelMainPresenter"

@FeatureScope
class HotelMainViewModel @Inject constructor(
    private val service: HotelService,
    @ApplicationScope private val appScope: CoroutineScope
): ViewModel() {
    fun getHotel() {
        Log.d(TAG, "${this.identify()} get hotel using service:${service.identify()}")
        service.getHotel()
    }

    fun testAppScope() {
        appScope.launch {
            logCounterInterval("appscope", this@HotelMainViewModel.identify())
        }
    }

    fun testViewModelScope() {
        viewModelScope.launch {
            logCounterInterval("viewmodelscope", this@HotelMainViewModel.identify())
        }
    }
}