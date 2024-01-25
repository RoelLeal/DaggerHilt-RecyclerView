package com.test.test.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.test.adapter.MainActivityViewModel
import com.test.test.adapter.RetroRecyclerViewAdapter
import com.test.test.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retroRecyclerViewAdapter: RetroRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {
                retroRecyclerViewAdapter.setListData(it)
                retroRecyclerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error getting data", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.loadLiveData()
    }

    private fun initRecyclerView() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        retroRecyclerViewAdapter = RetroRecyclerViewAdapter()
        binding.recycler.adapter = retroRecyclerViewAdapter
    }

}