package com.example.bilibeadsdesigns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.bilibeadsdesigns.databinding.ActivityRegistrationBinding
import com.example.loginactivity.DBHelper
import com.jakewharton.rxbinding2.widget.RxTextView

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var db: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = DBHelper(this)
//ito ung fullname validation
        //val nameStream = RxTextView.textChanges(binding.registerFullname)
           // .skipInitialValue()
           // .map { name ->
                //name.isEmpty()
           // }
        //nameStream.subscribe(){
            //showNameExistAlert(it)
        //}//

        // ito naman ung sa email validation
        val emailStream = RxTextView.textChanges(binding.registerEmail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe(){
            showEmailValidAlert(it)
        }




// itong ung username validation
        val  usernameStream = RxTextView.textChanges(binding.registerUsername)
            .skipInitialValue()
            .map { username ->
                username.length <6
            }
        usernameStream.subscribe{
            showTextMinimalAlert(it, "Username")
        }
// itong ung password validation
        val passwordStream = RxTextView.textChanges(binding.registerPassword)
            .skipInitialValue()
            .map { password ->
                password.length < 6
            }
        passwordStream.subscribe{
            showTextMinimalAlert(it, "Password")
        }
// ito ung confirm password validation

        val passwordConfirmStream = io.reactivex.Observable.merge(
            RxTextView.textChanges(binding.registerPassword)
                .skipInitialValue()
                .map { password ->
                    password.toString() !=binding.registerConfirmPassword.text.toString()
                },
            RxTextView.textChanges(binding.registerConfirmPassword)
                .skipInitialValue()
                .map { confirmPassword ->
                    confirmPassword.toString() !=binding.registerPassword.text.toString()

                })
        passwordConfirmStream.subscribe(){
            showPasswordConfirmAlert(it)
        }
// BUTTON ENABILE TRUE OR FALSE
        val invalidFieldsStream = io.reactivex.Observable.combineLatest(
            emailStream,usernameStream,passwordStream,
            passwordConfirmStream
        ) { emailInvalid: Boolean, usernameInvalid: Boolean,
            passwordInvalid: Boolean, passwordConfirmInvalid: Boolean ->
            !emailInvalid && !usernameInvalid && !passwordInvalid && !passwordConfirmInvalid
        }
        invalidFieldsStream.subscribe{isValid ->
            if(isValid){
                binding.btRegistration.isEnabled = true
                binding.btRegistration.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary_color)

            }else{
                binding.btRegistration.isEnabled = false
                binding.btRegistration.backgroundTintList = ContextCompat.getColorStateList(this,android.R.color.darker_gray)
            }
        }

        binding.btRegistration.setOnClickListener {
            val regUsername = binding.registerUsername.text.toString()
            val regPassword = binding.registerPassword.text.toString()
            if (regUsername.isNotEmpty()&& regPassword.isNotEmpty()){
            registerDatabase(regUsername,regPassword)
            }
        }
    }
    //private fun showNameExistAlert(isNotValid: Boolean){
       //binding.registerFullname.error = if (isNotValid)"Name is Valid!" else null
    //}
    private fun showTextMinimalAlert(isNotValid: Boolean, text: String){
        if(text=="Username")
            binding.registerUsername.error = if (isNotValid) "$text Hellow" else null
        else if (text == "Password")
            binding.registerPassword.error = if(isNotValid) "$text Halo" else null
    }
    private fun showEmailValidAlert(isNotValid: Boolean){
        binding.registerEmail.error = if (isNotValid)"Email is valid" else null
    }
    private fun showPasswordConfirmAlert(isNotValid: Boolean){
        binding.registerConfirmPassword.error = if(isNotValid) "Password is Valid" else null
    }
    private fun registerDatabase(username: String, password: String){
        val insertedRowId = db.insertUser(username,password)
        if (insertedRowId != -1L){
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "This user Exists", Toast.LENGTH_SHORT).show()
        }

    }
}