package com.yendangn.recylerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var rvPlace: RecyclerView
    private lateinit var mAdapter: PlaceAdapter
    private lateinit var mLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLayoutManager = LinearLayoutManager(this)

        val mDataSet = createDataSet()

        mAdapter = PlaceAdapter(mDataSet) { place ->
            onPlaceItemClick(place)
        }

        rvPlace = findViewById<RecyclerView>(R.id.rvPlace).apply {

            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }

    private fun onPlaceItemClick(place: Place) {
        Toast.makeText(this, place.name, Toast.LENGTH_LONG).show()
    }

    private fun createDataSet(): List<Place> {
        val places = ArrayList<Place>()

        places.add(Place(R.drawable.da_nang, "Da Nang City"))
        places.add(Place(R.drawable.sapa, "Sapa"))
        places.add(Place(R.drawable.ha_long_bay, "Ha Long"))
        places.add(Place(R.drawable.ha_noi, "Ha Noi"))
        places.add(Place(R.drawable.phan_thiet, "Phan Thiet"))

        return places
    }
}
