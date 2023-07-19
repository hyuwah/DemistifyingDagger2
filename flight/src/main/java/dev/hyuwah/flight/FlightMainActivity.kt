package dev.hyuwah.flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.hyuwah.core.di.ApplicationScope
import dev.hyuwah.flight.databinding.ActivityFlightMainBinding
import dev.hyuwah.flight.di.FlightComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlightMainActivity : AppCompatActivity(R.layout.activity_flight_main) {

    private val binding by viewBinding(ActivityFlightMainBinding::bind)

    @Inject
    @ApplicationScope
    lateinit var appScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        FlightComponent.injector(this).inject(this)
        super.onCreate(savedInstanceState)

        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.e("Coroutine", "$throwable")
        }

        binding.btnThrow.setOnClickListener {
            GlobalScope.launch(exceptionHandler) {
                Log.e("Coroutine", "GlobalScope Exception from Flight page")
                throw Exception("GlobalScope Exception from Flight page")
            }

            appScope.launch {
                Log.e("Coroutine", "AppScope Exception from Flight page")
                throw Exception("AppScope Exception from Flight page")
            }
        }

    }
}