package com.qordoq.app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val view = inflater.inflate(R.layout.fragment_profile, container, false)
            val fordynamic = view.findViewById<LinearLayout>(R.id.inearl)
            val sharedPref = activity?.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val uid = sharedPref?.getString("uid", "").toString()
            getProfileData(uid){ task ->
                for ((keys, value) in task) {
                    val tview = TextView(view.context)
                    tview.text = value.toString()
                    tview.textSize = 28F
                    fordynamic.addView(tview)
                } // for loop
            } // getProfileData block
            return view
    } // onCreteView block
} // ProfileFragment block