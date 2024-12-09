package com.qordoq.app

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LessonPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2  // Ikkita fragment

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NazariyaFragment()   // Nazariya sahifasi
            1 -> AmaliyotFragment()   // Amaliyot sahifasi
            else -> throw IllegalArgumentException("Noma'lum fragment")
        }
    }
}
