package com.example.detailscreen


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//const val BASE_URL="https://randomuser.me/api/"
class DetailScreen : AppCompatActivity() {
    lateinit var listOfUsers:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)


        listOfUsers = findViewById(R.id.listOfUsers)
        getMyData()
    }
    private fun getMyData(){
        var progressbar= findViewById<ProgressBar>(R.id.progress_bar)
        progressbar.visibility = View.VISIBLE
        progressbar.visibility = View.GONE
        progressbar.visibility = View.VISIBLE
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.npoint.io/")
            .build()
            .create(ApiIinterface::class.java)
        val retrofitData=retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {

              val responseBody=response.body()!!

                listOfUsers.layoutManager = LinearLayoutManager(this@DetailScreen)
                val adapter = MyAdapter(this@DetailScreen,responseBody.results)

                // Setting the Adapter with the recyclerview
                listOfUsers.adapter = adapter

                progressbar!!.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Toast.makeText(this@DetailScreen,""+t.toString(),Toast.LENGTH_SHORT).show();

            }
        })
    }
}