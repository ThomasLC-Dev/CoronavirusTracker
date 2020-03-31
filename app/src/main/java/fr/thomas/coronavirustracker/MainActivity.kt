package fr.thomas.coronavirustracker

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import fr.thomas.coronavirustracker.countrieslist.CountriesListFragment
import fr.thomas.coronavirustracker.home.WorldFragment
import kotlinx.android.synthetic.main.activity_main.*

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
