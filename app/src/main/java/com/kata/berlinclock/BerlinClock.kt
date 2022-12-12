package com.kata.berlinclock

import com.kata.berlinclock.model.BerlinClockModel
import com.kata.berlinclock.model.Hours
import com.kata.berlinclock.model.Minutes
import com.kata.berlinclock.utils.LightStatus
import com.kata.berlinclock.utils.LightStatus.*

class BerlinClock {
    fun getBerlinClock(time: String): BerlinClockModel {
        val timeComponents = time.split(":")

        val hours = getHours(timeComponents[0].toInt())
        val minutes = getMinutes(timeComponents[1].toInt())
        val seconds = getSeconds(timeComponents[2].toInt())

        return BerlinClockModel(
            seconds,
            hours,
            minutes)
    }

    private fun getHours(hours: Int): Hours {
        val topHoursOn = hours / 5
        val bottomHoursOn = hours % 5

        val defaultTopHours = MutableList(4) { OFF }
        val defaultBottomHours = MutableList(4) { OFF }

        return Hours(
            getHoursLightStatus(topHoursOn, defaultTopHours),
            getHoursLightStatus(bottomHoursOn, defaultBottomHours)
        )
    }

    private fun getHoursLightStatus(hours: Int, lightStatus: MutableList<LightStatus>): MutableList<LightStatus> {
        (1..hours).forEach { i ->
            lightStatus[i - 1] = RED
        }
        return lightStatus
    }

    private fun getMinutes(minutes: Int): Minutes {
        val topMinutesOn = minutes / 5
        val bottomMinutesOn = minutes % 5

        val defaultTopMinutes = MutableList(11) { OFF }
        val defaultBottomMinutes = MutableList(4) { OFF }

        return Minutes(
            getTopMinutesLightStatus(topMinutesOn, defaultTopMinutes),
            getBottomMinutesLightStatus(bottomMinutesOn, defaultBottomMinutes)
        )
    }

    private fun getTopMinutesLightStatus(hours: Int, lightStatus: MutableList<LightStatus>): MutableList<LightStatus> {
        (1..hours).forEach { i ->
            if (i % 3 == 0) {
                lightStatus[i - 1] = RED
            } else {
                lightStatus[i - 1] = YELLOW
            }
        }
        return lightStatus
    }

    private fun getBottomMinutesLightStatus(hours: Int, lightStatus: MutableList<LightStatus>): MutableList<LightStatus> {
        (1..hours).forEach { i ->
            lightStatus[i - 1] = YELLOW
        }
        return lightStatus
    }

    private fun getSeconds(seconds: Int): LightStatus {
        return if (seconds % 2 == 0) YELLOW else OFF
    }
}
