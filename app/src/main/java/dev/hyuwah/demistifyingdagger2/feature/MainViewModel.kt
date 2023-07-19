package dev.hyuwah.demistifyingdagger2.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.hyuwah.core.di.ApplicationScope
import dev.hyuwah.core.di.FeatureScope
import dev.hyuwah.core.logging.identify
import dev.hyuwah.core.network.NetworkClient
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

private const val TAG = "MainPresenter"

@FeatureScope
class MainViewModel @Inject constructor(
    private val networkClient: NetworkClient,
    @ApplicationScope private val applicationScope: CoroutineScope
): ViewModel() {

    fun fetch() {
        Log.d(TAG, "${this.identify()} fetching using client:${networkClient.identify()} & scope:${applicationScope}")
    }

}