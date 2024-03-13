package com.example.datatestlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.datatestlab.recyclerview.Animal
import com.example.datatestlab.recyclerview.AnimalAdapter
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class HomeActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var btnSignOut: Button
    private lateinit var rvRegisters: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Alert.show("Successfully sign in!","Welcome, user!",this)
        initComponents()
        initListeners()
        initRecyclerView()
    }
    private fun initComponents(){
        firebaseAuth = Firebase.auth
        btnSignOut = findViewById(R.id.btnSignOut)
        rvRegisters = findViewById(R.id.rvRegisters)
    }
    private fun initListeners(){
        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            finish()
        }
    }
    private fun initRecyclerView(){
        rvRegisters.layoutManager = LinearLayoutManager(this)
        rvRegisters.adapter = AnimalAdapter(getAllAnimals())
    }
    private fun getAllAnimals() : List<Animal>{
        val animals = listOf<Animal>()
        
        return animals
    }
}