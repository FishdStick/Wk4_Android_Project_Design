package com.example.wk4_android_project_design

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RegistrationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val registerButton = findViewById<View>(R.id.registerSignUpBtn) as Button
        registerButton.setOnClickListener { registerSuccess() }

        val registerBackButton = findViewById<View>(R.id.registerBackBtn) as FloatingActionButton
        registerBackButton.setOnClickListener { goToWelcomeScreen() }

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


}