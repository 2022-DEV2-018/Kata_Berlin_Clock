package com.kata.berlinclock

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.kata.berlinclock.adapter.BaseAdapter
import com.kata.berlinclock.adapter.TopMinutesAdapter
import com.kata.berlinclock.databinding.ActivityBerlinClockBinding
import com.kata.berlinclock.utils.LightStatus
import com.kata.berlinclock.viewmodel.BerlinClockViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class BerlinClockActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBerlinClockBinding
    private val viewModel: BerlinClockViewModel by viewModel()

    private lateinit var timer: CountDownTimer
    private val topHoursAdapter: BaseAdapter by lazy { BaseAdapter() }
    private val bottomHoursAdapter: BaseAdapter by lazy { BaseAdapter() }
    private val topMinutesAdapter: TopMinutesAdapter by lazy { TopMinutesAdapter() }
    private val bottomMinutesAdapter: BaseAdapter by lazy { BaseAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerlinClockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        setRecyclerView()
        startClock()
    }

    private fun observeViewModel() {
        viewModel.berlinClockTime.observe(this) {

            when (it.secondsLightStatus) {
                LightStatus.YELLOW -> binding.viewSeconds.setBackgroundColor(Color.YELLOW)
                else -> binding.viewSeconds.setBackgroundColor(Color.WHITE)
            }

            topHoursAdapter.setValue(it.hoursLampStatus .topHours)
            bottomHoursAdapter.setValue(it.hoursLampStatus.bottomHours)
            topMinutesAdapter.setValue(it.minutesLampStatus.topMinutes)
            bottomMinutesAdapter.setValue(it.minutesLampStatus.bottomMinutes)
        }
    }

    private fun setRecyclerView() {
        binding.recyclerviewTopHours.apply {
            adapter = topHoursAdapter
        }
        binding.recyclerviewBottomHours.apply {
            adapter = bottomHoursAdapter
        }
        binding.recyclerviewTopMinutes.apply {
            adapter = topMinutesAdapter
        }
        binding.recyclerviewBottomMinutes.apply {
            adapter = bottomMinutesAdapter
        }
        viewModel.updateBerlinClockInitialState()
    }

    private fun startClock() {
        timer = object : CountDownTimer(3600000, 1000) {
            override fun onTick(millisUntilFinished: Long) = updateUI()
            override fun onFinish() { start() }
        }
        timer.start()
    }

    private fun updateUI() {
        val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        binding.textviewClock.text = currentTime
        viewModel.updateBerlinClock(currentTime)
    }
}