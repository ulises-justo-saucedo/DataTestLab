package com.example.datatestlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
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
    private lateinit var alert: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initComponents()
        initListeners()
    }
    private fun initComponents(){
        firebaseAuth = Firebase.auth
        etEmail = findViewById<EditText>(R.id.etEmail)
        etPassword = findViewById<EditText>(R.id.etPassword)
        btnSignIn = findViewById<Button>(R.id.btnSignIn)
        btnSignUp = findViewById<Button>(R.id.btnSignUp)
        emailPattern = ".+@(gmail|outlook|hotmail)\\.com"
        regex = Regex(emailPattern)
        alert = AlertDialog.Builder(this)
    }
    private fun initListeners(){
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        btnSignIn.setOnClickListener {
            if(regex.matches(email) && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    signIn ->
                    if(signIn.isSuccessful){
                        //Launch another activity.
                    }else{
                        showAlert("Couldn't sign in!","Invalid email or password. Maybe not registered?")
                    }
                }
            }
        }
        btnSignUp.setOnClickListener {
            if(regex.matches(email) && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    signUp ->
                    if(signUp.isSuccessful){
                        showAlert("Sign up completed!","Successfully registered email ${email} !")
                    }else{
                        showAlert("Couldn't sign up!","Invalid email or password. Maybe already registered?")
                    }
                }
            }
        }
    }
    private fun showAlert(title: String, message: String){
        alert.setTitle(title)
        alert.setMessage(message)
        alert.show()
    }
}