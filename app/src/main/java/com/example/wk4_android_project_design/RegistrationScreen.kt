package com.example.wk4_android_project_design

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RegistrationScreen : AppCompatActivity() {

    private lateinit var firstNameET: EditText
    private lateinit var ageET: EditText
    private lateinit var usernameET: EditText
    private lateinit var EmailET: EditText
    private lateinit var passwordET: EditText
    private lateinit var registerSignUpBtn: Button
    private lateinit var registerBackBtn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        registerSignUpBtn = findViewById(R.id.registerSignUpBtn)
        registerSignUpBtn.setOnClickListener { registerSuccess() }

        registerBackBtn = findViewById(R.id.registerBackBtn)
        registerBackBtn.setOnClickListener { goToWelcomeScreen() }

        firstNameET = findViewById(R.id.firstNameET)
        ageET = findViewById(R.id.ageET)
        usernameET = findViewById(R.id.usernameET)
        EmailET = findViewById(R.id.EmailET)
        passwordET = findViewById(R.id.passwordET)

    }

    private fun goToWelcomeScreen() {
        val intent = Intent(this, WelcomeScreen::class.java)
        startActivity(intent)

    }

    private fun registerSuccess() {
        val intent = Intent(this, WelcomeScreen::class.java)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
        startActivity(intent)

    }

    //TODO
    // Validation for all text fields
    // Must follow the allowed characters

    private fun validateRegistrations() {
        var firstName = firstNameET.text.toString().trim()
        var age = ageET.text.toString().trim()
        var username = usernameET.text.toString().trim()
        var email = EmailET.text.toString().trim()
        var password = passwordET.text.toString().trim()

        when {
            email == testEmail && password == testPassword -> {
                goToMainScreen()
                finish()
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showToast("Enter a valid email!")
                return
            }
            TextUtils.isEmpty(email) -> {
                showToast("Email is required!")
                return
            }
            TextUtils.isEmpty(password) -> {
                showToast("Password is required!")
                return
            }
            else -> {
                showToast("Incorrect Email or Password!")
                return
            }
        }
    }


}