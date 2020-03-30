package fr.thomas.coronavirustracker.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.thomas.coronavirustracker.App
import fr.thomas.coronavirustracker.models.World
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WorldFragmentViewModel : ViewModel() {

    var world: MutableLiveData<World> = MutableLiveData<World>()

    fun refreshWorld(){

        val call = App.services.getWorld()

        call.enqueue(object : Callback<World> {
            override fun onResponse(call: Call<World>, response: Response<World>) {
                world.value = response.body()
            }

            override fun onFailure(call: Call<World>, t: Throwable) {

            }
        })
    }

}