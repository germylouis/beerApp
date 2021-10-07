package com.example.beerapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.beerapp.R
import com.example.beerapp.viewmodel.BeersViewModel
import com.example.beerapp.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: BeersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(application)).get(BeersViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewModel.getBeers().collect { value ->
                Log.d("Main", "onCreate: $value")
              }
        }
    }
}