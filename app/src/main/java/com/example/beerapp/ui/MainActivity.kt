package com.example.beerapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beerapp.databinding.ActivityMainBinding
import com.example.beerapp.ui.adapters.BeersAdapter
import com.example.beerapp.viewmodel.BeersViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var viewModel: BeersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)
        if (intent.getBundleExtra("intentOfBeers") == null) {
            Log.d("TAG", "onCreate: intent is null of beers :(")
        }

        binding.beersRv.apply {
            adapter = BeersAdapter(
                intent.getBundleExtra("intentOfBeers")
                    ?.getParcelableArrayList("bundleOfBeers")
            )
            layoutManager = manager
        }

//        lifecycleScope.launchWhenCreated {
//            viewModel.getBeers().collect { value ->
//                binding.beersRv.apply {
//                    adapter = BeersAdapter(value)
//                    layoutManager = manager
//                }
//
//                Log.d("Main", "onCreate: $value")
//            }
//        }

    }
}
