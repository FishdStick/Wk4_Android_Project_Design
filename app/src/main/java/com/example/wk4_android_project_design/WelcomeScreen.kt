package com.example.wk4_android_project_design

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToSignUpButton = findViewById<View>(R.id.signUpBtn) as Button
        goToSignUpButton.setOnClickListener { goToRegistrationScreen() }

        val goToLoginButton = findViewById<View>(R.id.welcomeLoginBtn) as Button
        goToLoginButton.setOnClickListener { goToLoginScreen() }

        val goToAccRetrievalButton = findViewById<View>(R.id.forgotAccBtn) as Button
        goToAccRetrievalButton.setOnClickListener { goToAccRetrievalScreen() }

    }

    private fun goToRegistrationScreen() {
        val intent = Intent(this, RegistrationScreen::class.java)
        startActivity(intent)
    }

    private fun goToLoginScreen() {
        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)
    }

    private fun goToAccRetrievalScreen() {
        val intent = Intent(this, AccountRetrievalScreen::class.java)
        startActivity(intent)
    }


}