package com.yendangn.recylerview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.widget.ImageView

class PlaceDetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Activity, view: View, image: Int) {

            val intent = Intent(context, PlaceDetailActivity::class.java)

            intent.apply {
                putExtra("IMAGE", image)
            }

            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(context, view, "image_place")

            context.startActivity(intent, option.toBundle())

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        val imgPlace = findViewById<ImageView>(R.id.imgPlace)

        val image = intent.getIntExtra("IMAGE", 0)
        imgPlace.setImageResource(image)
    }
}
