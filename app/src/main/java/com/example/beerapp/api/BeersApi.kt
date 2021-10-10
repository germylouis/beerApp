//source https://medium.com/google-developer-experts/how-to-use-ktor-client-on-android-dcdeddc066b9

package com.example.beerapp.api

import beersUrl
import com.example.beerapp.data.entities.Beer
import io.ktor.client.*
import io.ktor.client.request.*

class BeersApi(private val client: HttpClient) {
    suspend fun getBeersKtor(): MutableList<Beer> = client.get(beersUrl)
}
