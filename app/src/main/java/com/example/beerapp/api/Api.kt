package com.example.beerapp.api

import com.example.beerapp.data.entities.Beer
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {
    @GET()
    fun getBeersRetro(): Observable<MutableList<Beer>>
}
