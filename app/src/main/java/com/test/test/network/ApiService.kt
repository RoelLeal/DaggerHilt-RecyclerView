package com.test.test.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<RecyclerList>

}