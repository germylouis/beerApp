package com.example.beerapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beerapp.databinding.ActivityMainBinding
import com.example.beerapp.ui.adapters.BeersAdapter
import com.example.beerapp.viewmodel.BeersViewModel
import com.example.beerapp.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: BeersViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(application)).get(BeersViewModel::class.java)

//        lifecycleScope.launch {
//            viewModel.action.collect { beers ->
//                binding.beersRv.apply {
//                    adapter = BeersAdapter(beers, null)
//                    layoutManager = manager
//                }
//            }
//        }
        lifecycleScope.launchWhenCreated {
            viewModel.getBeers().collect { value ->
                binding.beersRv.apply {
                    adapter = BeersAdapter(value)
                    layoutManager = manager
                }

                Log.d("Main", "onCreate: $value")
            }
        }
    }
}