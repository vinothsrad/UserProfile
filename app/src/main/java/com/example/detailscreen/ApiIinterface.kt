package com.example.detailscreen

import retrofit2.Call
import retrofit2.http.GET

interface ApiIinterface {


    @GET("73e4f12c7b60b183ca6d")
    fun getData(): Call<MyData>

}