package com.example.beerapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerapp.api.BeersApi
import com.example.beerapp.api.BeersRepo
import com.example.beerapp.api.BeersRetroFitApi
import com.example.beerapp.api.BeersRetroFitApi.api
import com.example.beerapp.api.ktorHttpClient
import com.example.beerapp.data.entities.Beer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch

class BeersViewModel : ViewModel() {

    var TAG = "GERM: "

    private val _action = MutableSharedFlow<MutableList<Beer>>(replay = 0)
    private val compositeDisposable = CompositeDisposable()

    var rxBeers: MutableList<Beer> = mutableListOf()

    var ktroApi: BeersApi = BeersApi(ktorHttpClient)

    val action: SharedFlow<MutableList<Beer>>
        get() = _action

    init {
       // var api = BeersRepo()
    }

    suspend fun getBeers(): StateFlow<MutableList<Beer>> = flow {
        val data = ktroApi.getBeersKtor()
        emit(data)
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = mutableListOf()
    )

      fun getBeersRx() {
//        compositeDisposable.add(
//            api.getBeersRetro().subscribe({ beers ->
//                rxBeers = beers
//            },
//                {
//                    Log.d(TAG, "getBeersRx: Error - ${it.message}")
//                })
//        )
    }

    private fun openDetails() {
        viewModelScope.launch {
            _action.emit(ktroApi.getBeersKtor())
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
