package com.qordoq.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        if(sharedPref.getBoolean("isLogged", false)){
            setContentView(R.layout.activity_main)
        }// condition login if block
        else{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        } // condition login else block


//        startTimeChecker()
        val bnv: BottomNavigationView = findViewById(R.id.bnv)
        bnv.selectedItemId = R.id.home

        bnv.setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.leson -> loadFragment(LesonFragment(), this.supportFragmentManager)
                R.id.home -> loadFragment(HomeFragment(), this.supportFragmentManager)
                R.id.profile -> loadFragment(ProfileFragment(), this.supportFragmentManager)
                else -> {
                    loadFragment(HomeFragment(), this.supportFragmentManager)
                } // when else block
            }  // when block
        } // setOnItemSelectedListener block
    } // onCrete block

    private var handler = Handler(Looper.getMainLooper())

    private fun startTimeChecker() {
        handler.post(object : Runnable {
            override fun run() {
                showToast("1 daqiqa otdi")
                handler.postDelayed(this, 60000)
            } // run block
        }) // object block
    } // startTimeChecker block

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    } // showToast block
} // MainActivity context