package com.qordoq.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        if(sharedPref.getBoolean("isLogged", false))
            setContentView(R.layout.activity_main)
        else{
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
            finish() // `MainActivity` ni yopamiz
            return
        }
        fun loadFragment(fragment: Fragment): Boolean {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
            return true
        }
        val bnv: BottomNavigationView = findViewById(R.id.bnv)

        bnv.setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.leson -> loadFragment(LesonFragment())

                R.id.home -> true
                R.id.profile -> true
                else -> {
                    false
                }
            }
        }
    }


}