package com.example.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("gimme")
    fun getData(): Call<responseDataClass>
     /*
     Wrapped with call because when we use getData function at data retrieve,
     we need to get a calls/response and what's data we get when accessing.
     */
}