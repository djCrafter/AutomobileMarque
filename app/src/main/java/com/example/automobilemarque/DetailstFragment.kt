package com.example.automobilemarque


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detailst.*


class DetailstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailst, container, false)
    }

 override fun onActivityCreated(savedInstanceState: Bundle?) {
  super.onActivityCreated(savedInstanceState)
     val marqueName = activity!!.intent.getStringExtra("marque_name") ?: "BMW"


   if(activity?.intent != null) {
    displayMarque(marqueName)
   }
 }

  fun displayMarque(marqueName: String) {

      val imageID = resources.getIdentifier(marqueName.toLowerCase(), "drawable", activity!!.packageName)
      val textFileID = resources.getIdentifier(marqueName.toLowerCase(), "raw", activity!!.packageName)
      val fileText = resources.openRawResource(textFileID).bufferedReader().readText()

      marque_name.text = marqueName
      marque_image.setImageResource(imageID)
      marque_info.text = fileText
  }

}
