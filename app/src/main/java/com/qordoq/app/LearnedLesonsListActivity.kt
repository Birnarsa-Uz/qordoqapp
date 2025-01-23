package com.qordoq.app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LearnedLesonsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learned_lesons_list)
        findViewById<ImageView>(R.id.outFromThis).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}