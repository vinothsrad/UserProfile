package com.example.detailscreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.System.load

class userDetail : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val Name:TextView=findViewById(R.id.name)
        val Email:TextView=findViewById(R.id.email)
        val Gender:TextView=findViewById(R.id.gender)
        val Cell:TextView=findViewById(R.id.cell)
        val Phone:TextView=findViewById(R.id.phone)
        val Nat:TextView=findViewById(R.id.nat)
        val dob:TextView=findViewById(R.id.dob)
        val registered:TextView=findViewById(R.id.registered)
        val login:TextView=findViewById(R.id.login)
        val id:TextView=findViewById(R.id.id)
        val location:TextView=findViewById(R.id.location)

        val image_view:CircleImageView=findViewById(R.id.image_view)


        val bundle:Bundle?=intent.extras
        val userName=bundle!!.getString("name")
        val userEmail=bundle!!.getString("email")
        val userGender=bundle!!.getString("gender")
        val userCell=bundle!!.getString("cell")
        val userPhone=bundle!!.getString("phone")
        val userNat=bundle!!.getString("nat")
        val image=bundle!!.getString("image")
        val userdob=bundle!!.getString("dob")
        val userreg=bundle!!.getString("registered")
        val userLogin=bundle!!.getString("login")
        val userlocation=bundle!!.getString("location")
        val userId=bundle!!.getString("id")


        Glide.with(this)
        .load(image)
        .placeholder(R.drawable.d)
         .into(image_view);

        Name.text=userName
        Email.text=userEmail
        Gender.text=userGender
        Cell.text=userCell
        Phone.text=userPhone
        Nat.text=userNat
        dob.text=userdob
        registered.text=userreg
        login.text=userLogin
        id.text=userId
        location.text=userlocation






    }
}