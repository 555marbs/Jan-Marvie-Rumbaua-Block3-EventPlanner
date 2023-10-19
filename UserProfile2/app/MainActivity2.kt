package com.example.userprofile
package com.example.userprofile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

data class User(
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: String,
    var profilePicUrl: String
)

class MainActivity2 : AppCompatActivity() {

    private lateinit var user: User

    private lateinit var editFirstName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editAddress: EditText
    private lateinit var submitButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        user = User("Japeth", "Bianan", "japeth.bianan@gmail.com", "159 Bued, Calasiao", "url_of_profile_pic")

        editFirstName = findViewById(R.id.editFirstName)
        editLastName = findViewById(R.id.editLastName)
        editEmail = findViewById(R.id.editEmail)
        editAddress = findViewById(R.id.editAddress)
        submitButton = findViewById(R.id.submitButton)

        updateUI()

        submitButton.setOnClickListener {
            user.firstName = editFirstName.text.toString()
            user.lastName = editLastName.text.toString()
            user.email = editEmail.text.toString()
            user.address = editAddress.text.toString()

            updateUI()

            showToast("Profile updated successfully")
        }
    }

    private fun updateUI() {
        editFirstName.setText(user.firstName)
        editLastName.setText(user.lastName)
        editEmail.setText(user.email)
        editAddress.setText(user.address)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}