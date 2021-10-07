/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar
*/

package com.example.beerapp.data.entities


import kotlinx.serialization.*

@Serializable
data class Beer(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("tagline")
    val tagline: String,

    @SerialName("first_brewed")
    val first_brewed: String,

    @SerialName("description")
    val description: String,

    @SerialName("image_url")
    val image_url: String,

    @SerialName("abv")
    val abv: Double,

    @SerialName("ibu")
    val ibu: Double?,

    @SerialName("target_fg")
    val target_fg: Double,

    @SerialName("target_og")
    val target_og: Double,

    @SerialName("ebc")
    val ebc: Int?,

    @SerialName("srm")
    val srm: Double?,

    @SerialName("ph")
    val ph: Double?,

    @SerialName("attenuation_level")
    val attenuation_level: Double,

    @SerialName("volume")
    val volume: Volume,

    @SerialName("boil_volume")
    val boil_volume: Boil_volume,

    @SerialName("method")
    val method: Method,

    @SerialName("ingredients")
    val ingredients: Ingredients,

    @SerialName("food_pairing")
    val food_pairing: List<String>,

    @SerialName("brewers_tips")
    val brewers_tips: String,

    @SerialName("contributed_by")
    val contributed_by: String
)
