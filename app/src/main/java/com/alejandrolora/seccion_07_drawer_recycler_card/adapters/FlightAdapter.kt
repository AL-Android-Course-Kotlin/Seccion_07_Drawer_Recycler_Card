package com.alejandrolora.seccion_07_drawer_recycler_card.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.alejandrolora.seccion_07_drawer_recycler_card.R
import com.alejandrolora.seccion_07_drawer_recycler_card.inflate
import com.alejandrolora.seccion_07_drawer_recycler_card.listeners.RecyclerFlightListener
import com.alejandrolora.seccion_07_drawer_recycler_card.loadByResource
import com.alejandrolora.seccion_07_drawer_recycler_card.models.Flight
import kotlinx.android.synthetic.main.recycler_flight.view.*

class FlightAdapter(private val flights: List<Flight>, private val listener: RecyclerFlightListener)
    : RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycler_flight))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(flights[position], listener)

    override fun getItemCount() = flights.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flight: Flight, listener: RecyclerFlightListener) = with(itemView) {
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)
            // Clicks Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}