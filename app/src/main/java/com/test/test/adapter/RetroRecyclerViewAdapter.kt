package com.test.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.test.databinding.RecyclerRowBinding
import com.test.test.network.RecyclerData

class RetroRecyclerViewAdapter : RecyclerView.Adapter<RetroRecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setListData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val binding = RecyclerRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listData?.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return listData?.size?: 0
    }

    class MyViewHolder(private val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RecyclerData) {
            binding.name.text = data.name
            binding.description.text = data.description

            Glide
                .with(binding.thumbnailImage)
                .load(data.owner?.avatar_url)
                .into(binding.thumbnailImage)
        }
    }

}