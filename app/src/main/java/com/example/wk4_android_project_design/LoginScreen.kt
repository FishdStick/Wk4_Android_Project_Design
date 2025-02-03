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
        loginButton.setOnClickListener { goToMainScreen() }

    }

    private fun goToMainScreen() {

//        Logic for login validation

//        val getEmailText = findViewById<EditText>(R.id.loginEmailET);
//        val getPasswordText = findViewById<EditText>(R.id.loginPasswordET);
//        var email = getEmailText.text.toString();
//        var password = getPasswordText.text.toString();
//        var message = "";
//        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
//
//       if (email == "test@gmail.com" && password == "1234") {
//
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//
//        } else {
//
//            message = "Wrong Email or Password";
//            toast.show();
//
//        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }


}