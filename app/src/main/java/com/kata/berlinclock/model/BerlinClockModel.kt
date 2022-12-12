package com.kata.berlinclock.model

import com.kata.berlinclock.utils.LightStatus
import com.kata.berlinclock.utils.LightStatus.*

data class BerlinClockModel (
    val secondsLightStatus: LightStatus = YELLOW,
    val hoursLampStatus: Hours = Hours(),
    val minutesLampStatus : Minutes = Minutes()
)
