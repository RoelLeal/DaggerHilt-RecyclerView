package com.test.test.repository

import androidx.lifecycle.MutableLiveData
import com.test.test.network.ApiService
import com.test.test.network.RecyclerData
import com.test.test.network.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroApiService: ApiService) {

    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<RecyclerData>>) {
        val call: Call<RecyclerList> = retroApiService.getDataFromAPI(query)
        call.enqueue(object: Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items!!)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })


    }


}