package com.example.retrofitkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    //Creating retrofit object
    /*why lazy ?  because we write like equal to as well.
    ->  Two approaches to creating objects.
      1. private val retrofit=Retrofit.Builder....
      2. private val retrofit by lazy{ Retrofit.Builder...}
            Here we used second approach
     */

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://meme-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}