package com.betrybe.trybeclima.ui.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.betrybe.trybeclima.R
import com.betrybe.trybeclima.databinding.ActivityMainBinding
import com.betrybe.trybeclima.ui.viewmodel.MainActivityViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.mainTvCityName.windowToken, 0)
            val cityName = binding.mainTextField.text.toString()
            viewModel.getWeatherData(cityName)
        }

        binding.mainTextInputLayout.setEndIconOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.mainTvCityName.windowToken, 0)
            val cityName = binding.mainTextField.text.toString()
            viewModel.getWeatherData(cityName)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isErrorOccurred.collect { isErrorOccurred ->
                    if (isErrorOccurred) {
                        MaterialAlertDialogBuilder(this@MainActivity)
                            .setTitle("Trybe Clima")
                            .setMessage(viewModel.errorMessage.value)
                            .setCancelable(false)
                            .setPositiveButton("Ok") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .show()
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isForecastContainerVisible.collect { isForecastContainerVisible ->
                    if (isForecastContainerVisible) {
                        binding.mainClForecast.visibility = View.VISIBLE
                    } else {
                        binding.mainClForecast.visibility = View.INVISIBLE
                    }
                }
            }
        }

    }
}