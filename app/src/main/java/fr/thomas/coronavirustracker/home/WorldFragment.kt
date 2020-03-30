package fr.thomas.coronavirustracker.home

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import fr.thomas.coronavirustracker.R
import fr.thomas.coronavirustracker.models.World
import kotlinx.android.synthetic.main.fragment_world.*

class WorldFragment : Fragment() {

    private lateinit var viewModel: WorldFragmentViewModel
    private lateinit var world: World

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_world, container, false)

        val swipeRefresh = view.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout_world)
        swipeRefresh.setOnRefreshListener { viewModel.refreshWorld() }

        viewModel = ViewModelProvider(this).get(WorldFragmentViewModel::class.java)
        viewModel.world.observe(viewLifecycleOwner, Observer { updateWorld(it) })

        viewModel.refreshWorld()

        return view
    }

    private fun updateWorld(newWorld: World) {
        world = newWorld
        total_cases.text = "${world.cases}"
        total_deaths.text = "${world.deaths}"
        total_recovery.text = "${world.recovered}"
        swipe_refresh_layout_world.isRefreshing = false
    }

}