package com.example.automobilemarque

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TableRow
import kotlinx.android.synthetic.main.fragment_marque.*


class MarqueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marque, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for(i in 0..table_layout.childCount - 1) {
            val row = table_layout.getChildAt(i) as TableRow
            for(j in 0..row.childCount -1) {
                val button = row.getChildAt(j) as ImageButton
                button.setOnClickListener{
                    marqueClick(it)
                }
            }
        }
    }

    fun marqueClick(view: View) {
        val button: ImageButton = view as ImageButton
        val tag: String = button.tag.toString()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val myIntent = Intent(activity, DetailsActivity::class.java)
            myIntent.putExtra("marque_name", tag)
            startActivity(myIntent)
        }
        else{
           var detFragment = fragmentManager!!.findFragmentById(R.id.details_marque) as DetailstFragment
            detFragment.displayMarque(tag)

        }
    }
}
