package com.kata.berlinclock.model

import com.kata.berlinclock.utils.LightStatus
import com.kata.berlinclock.utils.LightStatus.*

data class Minutes(
    val topMinutes: List<LightStatus>,
    val bottomMinutes: List<LightStatus>
    ) {
    constructor() : this(
        listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF),
        listOf(OFF, OFF, OFF, OFF)
    )
}
