package fr.thomas.coronavirustracker.countrieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.thomas.coronavirustracker.R
import fr.thomas.coronavirustracker.models.Country

class CountriesListAdapter(private val countries: List<Country>, private val listener: CountriesListAdapterListener?) : RecyclerView.Adapter<CountriesListAdapter.ViewHolder>(), View.OnClickListener {

    interface CountriesListAdapterListener {
        fun onCountrySelected(country: Country)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        val countryFlag = itemView.findViewById<ImageView>(R.id.country_flag)
        val countryName = itemView.findViewById<TextView>(R.id.country_name)
        val countryCases = itemView.findViewById<TextView>(R.id.country_cases)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        with(holder){
            cardView.setOnClickListener(this@CountriesListAdapter)
            cardView.tag = country
            countryName.text = country.name
            countryCases.text = "Cases : ${country.cases} | Deaths : ${country.deaths}"
            Picasso.get().load(country.countryInfo.flag).placeholder(R.drawable.ic_placeholder_image).into(countryFlag)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.card_view -> {
                listener?.onCountrySelected(v.tag as Country)
            }
        }
    }

}