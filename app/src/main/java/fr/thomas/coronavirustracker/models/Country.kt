package fr.thomas.coronavirustracker.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country")
    var name: String,
    var countryInfo: CountryInfo,
    var cases: Int,
    var todayCases: Int,
    var deaths: Int,
    var todayDeaths: Int,
    var recovered: Int,
    var active: Int,
    var critical: Int
)

data class CountryInfo(
    var flag: String
)