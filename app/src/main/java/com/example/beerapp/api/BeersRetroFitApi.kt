package com.example.beerapp.api

import beersUrl
import com.example.beerapp.data.entities.Beer
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BeersRetroFitApi {

    var api: Api

    init {
        api = createApiInstance(getInstance())
    }

    private fun createApiInstance(mInstance: Retrofit): Api {
        return mInstance.create<Api>(Api::class.java)
    }

    private fun getInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(beersUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun getBeersRetro(): Observable<MutableList<Beer>> {
        return api.getBeersRetro()
    }
}
