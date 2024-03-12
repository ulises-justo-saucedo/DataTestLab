package com.example.datatestlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class AuthActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button
    private lateinit var regex: Regex
    private lateinit var emailPattern: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initComponents()
        initListeners()
    }
    private fun initComponents(){
        firebaseAuth = Firebase.auth
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)
        emailPattern = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]{2,6}$"
        regex = Regex(emailPattern)
    }
    private fun initListeners(){
        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if(regex.matches(email) && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    signIn ->
                    if(signIn.isSuccessful){
                        startActivity(Intent(this, HomeActivity::class.java))
                    }else{
                        Alert.show("Couldn't sign in!","Invalid email or password. Maybe not registered?",this)
                    }
                }
            }
        }
        btnSignUp.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if(regex.matches(email) && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    signUp ->
                    if(signUp.isSuccessful){
                        Alert.show("Sign up completed!","Successfully registered email ${email} !",this)
                    }else{
                        Alert.show("Couldn't sign up!","Invalid email or password. Maybe already registered?",this)
                    }
                }
            }
        }
    }

}