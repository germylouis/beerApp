package com.example.beerapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerapp.api.BeersApi
import com.example.beerapp.data.entities.Beer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.beerapp.api.ktorHttpClient
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class BeersViewModel : ViewModel() {

    var TAG = "GERM: "
    var api: BeersApi = BeersApi(ktorHttpClient)

    suspend fun getBeers() {
        val data = api.getBeersKtor()
        if (data == null) {
            Log.d(TAG, "getBeers: null")
        } else {
            for (i in data) {
                Log.d(TAG, "getBeers: ${i.name}")
            }
        }
    }
}