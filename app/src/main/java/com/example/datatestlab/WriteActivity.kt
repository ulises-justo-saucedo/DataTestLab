package com.example.datatestlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class WriteActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etType: EditText
    private lateinit var etAge: EditText
    private lateinit var btnConfirm: Button
    private lateinit var btnCancel: Button
    private lateinit var firebaseStore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        initComponents()
        initListeners()
    }
    private fun initComponents(){
        etName = findViewById(R.id.etName)
        etType = findViewById(R.id.etType)
        etAge = findViewById(R.id.etAge)
        btnConfirm = findViewById(R.id.btnConfirm)
        btnCancel = findViewById(R.id.btnCancel)
        firebaseStore = Firebase.firestore
    }
    private fun initListeners(){
        btnConfirm.setOnClickListener {
            val name = etName.text.toString()
            val type = etType.text.toString()
            val age = etAge.text.toString()
            val animal = hashMapOf(
                "name" to name,
                "type" to type,
                "age" to age
            )
            firebaseStore.collection("animals").add(animal).addOnCompleteListener {
                finish()
            }
        }
        btnCancel.setOnClickListener {
            finish()
        }
    }
}