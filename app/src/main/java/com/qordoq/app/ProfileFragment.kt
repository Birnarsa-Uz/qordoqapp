package com.qordoq.app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val view = inflater.inflate(R.layout.fragment_profile, container, false)
            val sharedPref = activity?.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val uid = sharedPref?.getString("uid", "").toString()
            val name = view.findViewById<TextView>(R.id.name)
            val fami = view.findViewById<TextView>(R.id.fami)
            getProfileData(uid){ task ->
                name.text = task["name"].toString()
                fami.text = task["lastname"].toString()
                view.findViewById<TextView>(R.id.class_name).text = task["class_name"].toString()
            } // getProfileData block
            view.findViewById<TextView>(R.id.learned_lessons).setOnClickListener{
                val sharedPref = activity?.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE) as SharedPreferences
                sharedPref.edit().putString("uid", "").putBoolean("isLogged", false).apply()
                startActivity(Intent(activity, LoginActivity::class.java))
                activity?.finish()
                return@setOnClickListener
            }
            view.findViewById<TextView>(R.id.learned_lessons).setOnClickListener{
                startActivity(Intent(requireActivity(), LearnedLesonsListActivity::class.java))
            }
            return view
    } // onCreteView block
} // ProfileFragment block