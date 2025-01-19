package com.qordoq.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn = findViewById<Button>(R.id.login)
        val uid = findViewById<EditText>(R.id.uid)
        val password = findViewById<EditText>(R.id.password)

        btn.setOnClickListener{
            val g_uid = uid.text.toString()
            val g_pass = password.text.toString()
            loginUser(g_uid, g_pass){task ->
                if(task["progress"] == "Correct"){
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    getSharedPreferences("UserPrefs", Context.MODE_PRIVATE).edit().apply{
                        putBoolean("isLogged", true)
                        putString("class_id", task["class_id"].toString())
                        putString("uid", g_uid)
                        apply()
                    }
                    val mainA = Intent(this, MainActivity::class.java)
                    startActivity(mainA)
                }else if(task["progress"] == "Undefinded"){
                    uid.text.clear()
                    password.text.clear()
                    Toast.makeText(this, "ID raqam topilmadi", Toast.LENGTH_LONG).show()
                }else if(task["progress"] == "Incorrect"){
                    password.text.clear()
                    Toast.makeText(this, "Parol xato", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, task["progress"].toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}