package com.example.beerapp.api

import com.example.beerapp.data.entities.Beer
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class BeersRepo {
    suspend fun getBeers(): Observable<MutableList<Beer>> {
        return BeersRetroFitApi.getBeersRetro()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
