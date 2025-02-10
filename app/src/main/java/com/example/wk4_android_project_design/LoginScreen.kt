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

class LoginScreen : AppCompatActivity() {
    private lateinit var loginEmailET: EditText
    private lateinit var loginPasswordET: EditText
    private lateinit var loginBtn: Button
    private lateinit var loginBackBtn: FloatingActionButton

    private val testEmail = "test@gmail.com"
    private val testPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginEmailET = findViewById(R.id.loginEmailET)
        loginPasswordET = findViewById(R.id.loginPasswordET)
        loginBtn = findViewById(R.id.loginBtn)
        loginBackBtn = findViewById(R.id.loginBackBtn)

        loginBtn.setOnClickListener {
            validateLoginCredentials()
        }

        loginBackBtn.setOnClickListener {
            goToWelcomeScreen()
        }

    }

    private fun goToMainScreen() {
        val mainMenu = Intent(this, MainActivity::class.java)
        startActivity(mainMenu)

    }

    private fun goToWelcomeScreen() {
        val welcomeScreen = Intent(this, WelcomeScreen::class.java)
        startActivity(welcomeScreen)

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    // Logic for login validation
    private fun validateLoginCredentials(){

        var email = loginEmailET.text.toString().trim()
        var password = loginPasswordET.text.toString().trim()

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