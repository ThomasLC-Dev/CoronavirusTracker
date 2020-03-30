package fr.thomas.coronavirustracker.info

import fr.thomas.coronavirustracker.models.Country
import fr.thomas.coronavirustracker.models.World
import retrofit2.Call
import retrofit2.http.GET

interface HttpInfoServicesJson {

    @GET("all")
    fun getWorld() : Call<World>

    @GET("countries")
    fun getCountries() : Call<List<Country>>

    @GET("countries?sort=cases")
    fun getCountriesSortByCases() : Call<List<Country>>

}