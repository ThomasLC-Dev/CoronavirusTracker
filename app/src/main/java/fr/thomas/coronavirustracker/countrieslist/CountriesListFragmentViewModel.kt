package fr.thomas.coronavirustracker.countrieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.thomas.coronavirustracker.App
import fr.thomas.coronavirustracker.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesListFragmentViewModel : ViewModel() {

    var countries: MutableLiveData<List<Country>> = MutableLiveData()

    fun refreshCountries(){

        val call = App.services.getCountriesSortByCases()

        call.enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                countries.value = response.body()
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {

            }
        })
    }

}