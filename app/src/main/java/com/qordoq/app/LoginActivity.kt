package com.qordoq.app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn = findViewById<Button>(R.id.login)

        btn.setOnClickListener{
            val db = Firebase.firestore
            val data = hashMapOf(
                "qordoq" to "qordoq",
            )
            db.collection("dasf").document("123").set(data)
        }
    }
}