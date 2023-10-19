package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var logoutButton: TextView
    private lateinit var backButton: ImageView
    private lateinit var editButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logoutButton = findViewById(R.id.logoutButton)
        backButton = findViewById(R.id.backButton)
        editButton = findViewById(R.id.editButton)

        logoutButton.setOnClickListener {
            logout()
        }

        backButton.setOnClickListener {
            finish()
        }

        editButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, EDIT_PROFILE_REQUEST)
        }
    }

    private fun logout() {
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EDIT_PROFILE_REQUEST = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_PROFILE_REQUEST && resultCode == Activity.RESULT_OK) {
            val editedData = data?.getStringExtra("editedData")
            Toast.makeText(this, "Profile updated: $editedData", Toast.LENGTH_SHORT).show()
        }
    }
}