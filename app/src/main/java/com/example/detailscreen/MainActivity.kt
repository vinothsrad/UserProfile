package com.example.detailscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var userName: EditText
    lateinit var password: EditText
    private lateinit var btnLog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName=findViewById(R.id.username)
        password=findViewById(R.id.password)
        btnLog=findViewById(R.id.loginbtn)

        btnLog.setOnClickListener(){
            loginUser()
        }
    }
    private fun loginUser()
    {
        val user=userName.text.toString()
        val pass=password.text.toString()


        if (user.matches(regex = Regex("^[a-zA-Z0-9._-]{3,}\$"))){
            userName.error = "Fill the correct userName."

        }
        else if (!user.matches(Regex(".*\\d.*")))
        {
            userName.error = "UserName must contain at least one number"
        }
        else if (user.isEmpty())
        {
            userName.error = "UserName is empty"
        }
        else if (user.length<6)
        {
            userName.error = "UserName must contain 6 charector"
        }

        else if (pass.length < 8) {
            password.error = "Password must be at least 8 characters long"
        } else if (!pass.matches(Regex(".*[A-Z].*"))) {
            password.error = "Password must contain at least one uppercase letter"
        } else if (!pass.matches(Regex(".*[a-z].*"))) {
            password.error = "Password must contain at least one lowercase letter"
        } else if (!pass.matches(Regex(".*\\d.*"))) {
            password.error = "Password must contain at least one number"
        }

        else
        {
            val userScreen=Intent(this,DetailScreen::class.java)
            startActivity(userScreen)
        }





    }




}