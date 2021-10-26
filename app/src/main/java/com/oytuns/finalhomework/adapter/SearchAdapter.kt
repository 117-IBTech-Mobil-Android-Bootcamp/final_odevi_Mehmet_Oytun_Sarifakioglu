package com.oytuns.finalhomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oytuns.finalhomework.R
import com.oytuns.finalhomework.model.Cities
import kotlinx.android.synthetic.main.weather_item.view.locationName

class SearchAdapter(val locaitonList : ArrayList<Cities>): RecyclerView.Adapter<SearchAdapter.LocationViewHolder>() {

    class LocationViewHolder(var view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_detail,parent,false)
        return LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.view.locationName.text = locaitonList[position].name
    }

    override fun getItemCount(): Int {
        return locaitonList.size
    }

    fun updateLocations(currentCities : List<Cities>){
        locaitonList.clear()
        locaitonList.addAll(currentCities)
        notifyDataSetChanged()
    }
}