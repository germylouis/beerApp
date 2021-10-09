package com.example.beerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerapp.api.BeersApi
import com.example.beerapp.api.ktorHttpClient
import com.example.beerapp.data.entities.Beer
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch

class BeersViewModel : ViewModel() {

    var TAG = "GERM: "
    var api: BeersApi = BeersApi(ktorHttpClient)
    private val _action = MutableSharedFlow<MutableList<Beer>>(replay = 0)
    val action: SharedFlow<MutableList<Beer>>
        get() = _action

    init {
        //openDetails()
    }

    suspend fun getBeers(): StateFlow<MutableList<Beer>> = flow {
        val data  = api.getBeersKtor()
        emit(data)
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = mutableListOf()
    )

    private fun openDetails() {
        viewModelScope.launch {
            _action.emit(api.getBeersKtor())
        }
    }
}
