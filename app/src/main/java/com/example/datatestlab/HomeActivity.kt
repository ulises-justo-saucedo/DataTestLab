package com.example.datatestlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class HomeActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var btnSignOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Alert.show("Successfully sign in!","Welcome, user!",this)
        initComponents()
        initListeners()
    }
    private fun initComponents(){
        firebaseAuth = Firebase.auth
        btnSignOut = findViewById(R.id.btnSignOut)
    }
    private fun initListeners(){
        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            finish()
        }
    }
}