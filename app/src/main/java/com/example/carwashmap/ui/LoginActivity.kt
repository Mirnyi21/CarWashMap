package com.example.carwashmap.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.carwashmap.MainActivity
import com.example.carwashmap.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        // Проверка пользователя на прошлый вход
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // переход на главную
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val emailField = findViewById<EditText>(R.id.email_login)
        val passwordField = findViewById<EditText>(R.id.password_login)
        val signInButton = findViewById<Button>(R.id.sign_in_login)
        val registrationButton = findViewById<Button>(R.id.registration_login)

        signInButton.setOnClickListener {

            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // добавить функцию проверки ввода
            // добавить trim

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        Toast.makeText(
                            baseContext,
                            "Успешный вход.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        val intent = Intent(this, MainActivity::class.java)
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

        registrationButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}