package com.test.test.adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.test.network.RecyclerData
import com.test.test.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {

    private var liveDataList: MutableLiveData<List<RecyclerData>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<RecyclerData>> {
        return liveDataList
    }

    fun loadLiveData() {
        repository.makeApiCall("linus", liveDataList)
    }

}