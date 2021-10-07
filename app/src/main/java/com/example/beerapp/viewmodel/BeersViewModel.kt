package com.example.beerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerapp.api.BeersApi
import com.example.beerapp.api.ktorHttpClient
import com.example.beerapp.data.entities.Beer
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class BeersViewModel : ViewModel() {

    var TAG = "GERM: "
    var api: BeersApi = BeersApi(ktorHttpClient)
    private val trigger = MutableLiveData<Beer>()

    suspend fun getBeers(): StateFlow<MutableList<Beer>> = flow {
        emit(api.getBeersKtor())
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000), // Or Lazily because it's a one-shot
        initialValue = mutableListOf()
    )
}
