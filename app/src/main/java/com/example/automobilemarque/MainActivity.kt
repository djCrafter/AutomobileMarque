package com.example.automobilemarque

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_marque_activity)
    }

    fun marqueClick(view: View) {
        val button: ImageButton = view as ImageButton
        val tag: String = button.tag.toString()

        val myIntent = Intent(this, DetailsActivity::class.java)
        myIntent.putExtra("marque_name", tag)
        startActivity(myIntent)
    }


}
