package com.kata.berlinclock.model

import com.kata.berlinclock.utils.LightStatus
import com.kata.berlinclock.utils.LightStatus.*

data class Hours(
    val topHours: List<LightStatus>,
    val bottomHours: List<LightStatus>
    ) {
    constructor() : this(
        listOf(OFF, OFF, OFF, OFF),
        listOf(OFF, OFF, OFF, OFF)
    )
}
