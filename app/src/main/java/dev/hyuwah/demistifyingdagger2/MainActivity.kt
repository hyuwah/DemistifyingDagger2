package dev.hyuwah.demistifyingdagger2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.hyuwah.core.di.coreProvider
import dev.hyuwah.demistifyingdagger2.databinding.ActivityMainBinding
import dev.hyuwah.demistifyingdagger2.di.DaggerMainFeatureComponent
import dev.hyuwah.demistifyingdagger2.di.MainFeatureComponent
import dev.hyuwah.demistifyingdagger2.feature.MainViewModel
import dev.hyuwah.flight.FlightMainActivity
import dev.hyuwah.hotel.HotelMainActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        MainFeatureComponent.injector(this).inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        super.onCreate(savedInstanceState)

        viewModel.fetch()

        binding.btnHotel.setOnClickListener {
            startActivity(Intent(this, HotelMainActivity::class.java))
        }
        binding.btnFlight.setOnClickListener {
            startActivity(Intent(this, FlightMainActivity::class.java))
        }
//        binding.btnCrypto.setOnClickListener {
//
//        }
//        binding.btnStocks.setOnClickListener {
//
//        }
    }
}