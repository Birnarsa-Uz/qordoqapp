package com.qordoq.app

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("StaticFieldLeak")
val db = Firebase.firestore
val student = db.collection("students")
fun loginUser(uid: String, password: String, onResult: (HashMap<*, *>) -> Unit) {
    db.collection("students").document(uid).get().addOnSuccessListener { task ->
        if (task.exists()) {
            if(task.getString("password") == password){
                onResult(hashMapOf("progress" to "Correct", "class_id" to (task.getString("class_id") ?: "")))
            }else{
                onResult(hashMapOf("progress" to "Incorrect"))
            }
        } else {
            onResult(hashMapOf("progress" to "Undefinded"))
        }
    }.addOnFailureListener{t -> onResult(hashMapOf("progress" to t.message.toString()))}
}


fun loadFragment(fragment: Fragment, supportFragmentManager: androidx.fragment.app.FragmentManager): Boolean {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
    return true
}

fun getProfileData(uid: String, onResult: (HashMap<*, *>) -> Unit) {

    student.document(uid).get().addOnSuccessListener {
        if(it.exists()){
            val name = it.getString("name").toString()
            val lastname = it.getString("lastname").toString()
            db.collection(it.getString("class_id").toString()).document("class_data").get().addOnSuccessListener { task ->
                val class_name = task.getString("class_name").toString()
                onResult(hashMapOf("name" to name, "lastname" to lastname, "class_name" to class_name))
            }.addOnFailureListener{ t ->
                onResult(hashMapOf("error" to "xatolik"))
            }
        }
    }
}
