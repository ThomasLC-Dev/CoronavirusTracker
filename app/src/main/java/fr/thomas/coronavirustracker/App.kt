package fr.thomas.coronavirustracker

import android.app.Application
import fr.thomas.coronavirustracker.info.HttpInfoServicesJson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object{
        lateinit var services: HttpInfoServicesJson
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder().baseUrl("https://corona.lmao.ninja/").addConverterFactory(
            GsonConverterFactory.create()).build()

        services = retrofit.create(HttpInfoServicesJson::class.java)
    }

}