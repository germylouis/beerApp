package com.example.beerapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.beerapp.R
import com.example.beerapp.data.entities.Beer
import com.example.beerapp.viewmodel.BeersViewModel
import com.example.beerapp.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
    lateinit var viewModel: BeersViewModel
    lateinit var beer: MutableList<Beer>
    lateinit var mainIntent: Intent
    lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        bundle = Bundle()
        mainIntent = Intent(this, MainActivity::class.java)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(application)).get(BeersViewModel::class.java)
        loadBeers()
    }

    private fun loadBeers() {
        lifecycleScope.launch {
            viewModel.getBeers().collect { beers ->
                bundle.putParcelableArrayList("bundleOfBeers", beers as ArrayList<out Parcelable>)
                mainIntent.putExtra("intentOfBeers", bundle)
                when (beers != emptyList<Beer>()) {
                    true -> {
                        startActivity(mainIntent)
                        finish()
                    }
                }
            }
        }
    }
}
