package com.kata.berlinclock.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kata.berlinclock.BerlinClock
import com.kata.berlinclock.model.BerlinClockModel

class BerlinClockViewModel(private val berlinClock: BerlinClock) : ViewModel() {

    var berlinClockTime = MutableLiveData<BerlinClockModel>()

    fun updateBerlinClockInitialState() {
        berlinClockTime.postValue(BerlinClockModel())
    }

    fun updateBerlinClock(time: String) {
        val result = berlinClock.getBerlinClock(time)
        berlinClockTime.postValue(result)
    }
}