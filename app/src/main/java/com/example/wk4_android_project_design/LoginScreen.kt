package com.example.wk4_android_project_design

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginButton = findViewById<View>(R.id.loginBtn) as Button
        val getEmailText = findViewById<EditText>(R.id.loginEmailET);
        val getPasswordText = findViewById<EditText>(R.id.loginPasswordET);

        val email = getEmailText.text;
        val password = getPasswordText.text;

        if (email.equals("test@gmail.com") && password.equals("1234")) {
            loginButton.setOnClickListener { goToMainScreen() }

        } else {
            val toast = Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT)
            toast.show();
        }
    }

    private fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}