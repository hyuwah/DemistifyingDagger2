package dev.hyuwah.hotel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.hyuwah.core.logging.identify
import dev.hyuwah.core.logging.logCounterInterval
import dev.hyuwah.hotel.databinding.ActivityHotelMainBinding
import dev.hyuwah.hotel.di.HotelComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class HotelMainActivity : AppCompatActivity(R.layout.activity_hotel_main) {

    private val binding by viewBinding(ActivityHotelMainBinding::bind)

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: HotelMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        HotelComponent.injector(this).inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[HotelMainViewModel::class.java]

        super.onCreate(savedInstanceState)

        viewModel.getHotel()

        binding.btnLog.setOnClickListener {
            viewModel.testViewModelScope()
            viewModel.testAppScope()
            lifecycleScope.launch {
                logCounterInterval("lifecyclescope", this@HotelMainActivity.identify())
            }
            GlobalScope.launch {
                logCounterInterval("globalscope", this@HotelMainActivity.identify())
            }
        }

    }
}