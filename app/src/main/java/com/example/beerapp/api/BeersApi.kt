package com.example.beerapp.api

import com.example.beerapp.data.entities.Beer
import io.ktor.client.*
import io.ktor.client.request.*

class BeersApi(private val client: HttpClient) {
    suspend fun getBeersKtor(): MutableList<Beer> = client.get("https://api.punkapi.com/v2/beers")
}