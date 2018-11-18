package com.yendangn.recylerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.place_item_layout.view.*

class PlaceAdapter(private val mDataSet: List<Place>, private val itemClickListener: (Place) -> Unit) :
    RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, postion: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_item_layout, parent, false)

        return PlaceViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: PlaceViewHolder, postion: Int) {
        viewHolder.bindPlace(mDataSet[postion], itemClickListener)
    }

    override fun getItemCount() = mDataSet.size


    class PlaceViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindPlace(place: Place, itemClickListener: (Place) -> Unit) {
            view.imgBackground.setImageResource(place.image)
            view.tvName.text = place.name

            view.setOnClickListener { itemClickListener(place) }
        }
    }
}


