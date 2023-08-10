package com.example.carwashmap.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carwashmap.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistrationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val emailField = findViewById<EditText>(R.id.email_registration)
        val passwordField = findViewById<EditText>(R.id.pass_registration)
        val registrationButton = findViewById<Button>(R.id.regist_btn)

        // Initialize Firebase Auth
        auth = Firebase.auth

        registrationButton.setOnClickListener {

            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // добавить функцию проверки ввода
            // добавить trim

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        Toast.makeText(
                            baseContext,
                            "Успешная регистрация.",
                            Toast.LENGTH_SHORT,
                        ).show()

                        // переход на главную
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        passwordField.text.clear()
                    }
                }

        }

    }
}