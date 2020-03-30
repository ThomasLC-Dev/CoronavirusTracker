package fr.thomas.coronavirustracker.countrieslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import fr.thomas.coronavirustracker.R
import fr.thomas.coronavirustracker.models.Country
import kotlinx.android.synthetic.main.fragment_countries_list.*

class CountriesListFragment : Fragment(), CountriesListAdapter.CountriesListAdapterListener {

    private lateinit var viewModel: CountriesListFragmentViewModel
    private lateinit var countryAdapter: CountriesListAdapter
    private lateinit var countries: MutableList<Country>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_countries_list, container, false)
        countries = mutableListOf()
        countryAdapter = CountriesListAdapter(countries, this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = countryAdapter

        val swipeRefresh = view.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)
        swipeRefresh.setOnRefreshListener { viewModel.refreshCountries() }

        viewModel = ViewModelProvider(this).get(CountriesListFragmentViewModel::class.java)
        viewModel.countries.observe(viewLifecycleOwner, Observer { updateCountries(it) })

        viewModel.refreshCountries()

        return view
    }

    private fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        countryAdapter.notifyDataSetChanged()
        swipe_refresh_layout.isRefreshing = false
    }

    override fun onCountrySelected(country: Country) {
        Log.i("CountriesListFragment","Country : $country")
    }

}