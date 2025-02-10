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

class AccountRetrievalScreen : AppCompatActivity() {

    private lateinit var actRetEmailAddressET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account_retrieval_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val retrieveAccountButton = findViewById<View>(R.id.accRetrievalButton) as Button
        retrieveAccountButton.setOnClickListener { validateRetrievalEmail() }

        val retrieveAccountBackButton = findViewById<View>(R.id.accRetBackButton) as FloatingActionButton
        retrieveAccountBackButton.setOnClickListener { goToWelcomeScreen() }

        actRetEmailAddressET = findViewById(R.id.actRetEmailAddressET)

    }

    private fun goToWelcomeScreen() {
        val intent = Intent(this, WelcomeScreen::class.java)
        startActivity(intent)
    }

    private fun accountRetrievalSuccess() {
        val intent = Intent(this, WelcomeScreen::class.java)
        Toast.makeText(this, "Account Retrieval Successful", Toast.LENGTH_SHORT).show()
        startActivity(intent)

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun validateRetrievalEmail(){

        var actRetEmail = actRetEmailAddressET.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(actRetEmail).matches()){
            showToast("Please enter a valid email!")

        } else {
            accountRetrievalSuccess()
        }


    }
}