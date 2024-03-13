package com.example.datatestlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datatestlab.recyclerview.Animal
import com.example.datatestlab.recyclerview.AnimalAdapter
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseStore: FirebaseFirestore
    private lateinit var btnSignOut: Button
    private lateinit var btnWrite: Button
    private lateinit var rvRegisters: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Alert.show("Successfully sign in!","Welcome, user!",this)
        initComponents()
        initListeners()
        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }
    private fun initComponents(){
        firebaseAuth = Firebase.auth
        firebaseStore = Firebase.firestore
        btnSignOut = findViewById(R.id.btnSignOut)
        btnWrite = findViewById(R.id.btnWrite)
        rvRegisters = findViewById(R.id.rvRegisters)
    }
    private fun initListeners(){
        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            finish()
        }
        btnWrite.setOnClickListener {
            startActivity(Intent(this, WriteActivity::class.java))
        }
    }
    private fun initRecyclerView(){
        rvRegisters.layoutManager = LinearLayoutManager(this)
        rvRegisters.adapter = AnimalAdapter(getAllAnimals())
    }
    private fun getAllAnimals(): List<Animal> {
        val animals = mutableListOf<Animal>()

        //Running get() query in a coroutine so it awaits to get it done before fetching data
        runBlocking {
            withContext(Dispatchers.IO){
                val querySnapshot = firebaseStore.collection("animals").get().await()
                for (data in querySnapshot) {
                    animals.add(data.toObject<Animal>())
                }
            }
        }

        return animals
    }
}