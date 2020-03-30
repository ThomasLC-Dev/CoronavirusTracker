package fr.thomas.coronavirustracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import fr.thomas.coronavirustracker.countrieslist.CountriesListFragment
import fr.thomas.coronavirustracker.home.WorldFragment
import fr.thomas.coronavirustracker.info.HttpInfoServicesJson
import fr.thomas.coronavirustracker.models.Country
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CountriesListFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, WorldFragment()).commit()
        bottom_bar.setOnNavigationItemSelectedListener {bottomNavigationBarItem(it)}
    }

    private fun bottomNavigationBarItem(item: MenuItem): Boolean {

        var fragment = when(item.itemId){
            R.id.bottom_navigation_bar_world-> {
                WorldFragment()
            }
            R.id.bottom_navigation_bar_country -> {
                CountriesListFragment()
            }
            else -> {
                return false
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        return true

    }

}
