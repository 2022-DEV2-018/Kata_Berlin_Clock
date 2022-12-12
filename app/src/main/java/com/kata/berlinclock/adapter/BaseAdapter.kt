package com.kata.berlinclock.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kata.berlinclock.databinding.BerlinClockItemLayoutBinding
import com.kata.berlinclock.utils.LightStatus
import com.kata.berlinclock.utils.LightStatus.*

class BaseAdapter : RecyclerView.Adapter<BaseAdapter.MyViewHolder>() {

    private lateinit var lampsOn: List<LightStatus>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView = BerlinClockItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            holder.bind(lampsOn[position])
        }
    }

    override fun getItemCount() = 4

    fun setValue(values: List<LightStatus>) {
        lampsOn = values
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val binding: BerlinClockItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(lightStatus: LightStatus) {
            var color = Color.WHITE
            when(lightStatus) {
                YELLOW -> color = Color.YELLOW
                RED -> color = Color.RED
                else -> Color.WHITE
            }
            binding.viewItem.setBackgroundColor(color)
        }
    }
}
