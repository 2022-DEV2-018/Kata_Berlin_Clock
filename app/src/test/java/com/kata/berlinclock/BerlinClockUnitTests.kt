package com.kata.berlinclock

import com.kata.berlinclock.model.BerlinClockModel
import com.kata.berlinclock.model.Hours
import com.kata.berlinclock.model.Minutes
import com.kata.berlinclock.utils.LightStatus.*
import org.junit.Test

import org.junit.Assert.*

class BerlinClockUnitTests {
    private val berlinClock = BerlinClock()

    @Test
    fun test_0_second_light_on() {
        val result = berlinClock.getBerlinClock("00:00:00")

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_1_second_light_off() {
        val result = berlinClock.getBerlinClock("00:00:01")

        val expectedResult = BerlinClockModel(OFF, Hours(), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_even_second_light_on() {
        val result = berlinClock.getBerlinClock("00:00:16")

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_even_second_light_off() {
        val result = berlinClock.getBerlinClock("00:00:55")

        val expectedResult = BerlinClockModel(OFF, Hours(), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_1_minute_light() {
        val result = berlinClock.getBerlinClock("00:01:00")

        val topMinutes = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_2_minute_light() {
        val result = berlinClock.getBerlinClock("00:02:00")

        val topMinutes = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_3_minute_light() {
        val result = berlinClock.getBerlinClock("00:03:00")

        val topMinutes = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_4_minute_light() {
        val result = berlinClock.getBerlinClock("00:04:00")

        val topMinutes = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, YELLOW)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_5_minute_light() {
        val result = berlinClock.getBerlinClock("00:05:00")

        val topMinutes = listOf(YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_8_minute_light() {
        val result = berlinClock.getBerlinClock("00:08:00")

        val topMinutes = listOf(YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_10_minute_light() {
        val result = berlinClock.getBerlinClock("00:10:00")

        val topMinutes = listOf(YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_12_minute_light() {
        val result = berlinClock.getBerlinClock("00:12:00")

        val topMinutes = listOf(YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_15_minute_light() {
        val result = berlinClock.getBerlinClock("00:15:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_20_minute_light() {
        val result = berlinClock.getBerlinClock("00:20:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_25_minute_light() {
        val result = berlinClock.getBerlinClock("00:25:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_29_minute_light() {
        val result = berlinClock.getBerlinClock("00:29:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, YELLOW)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_30_minute_light() {
        val result = berlinClock.getBerlinClock("00:30:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_35_minute_light() {
        val result = berlinClock.getBerlinClock("00:35:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_40_minute_light() {
        val result = berlinClock.getBerlinClock("00:40:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_45_minute_light() {
        val result = berlinClock.getBerlinClock("00:45:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_46_minute_light() {
        val result = berlinClock.getBerlinClock("00:46:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_50_minute_light() {
        val result = berlinClock.getBerlinClock("00:50:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_55_minute_light() {
        val result = berlinClock.getBerlinClock("00:55:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_59_minute_light() {
        val result = berlinClock.getBerlinClock("00:59:00")

        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, YELLOW)

        val expectedResult = BerlinClockModel(YELLOW, Hours(), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_1_hour_light() {
        val result = berlinClock.getBerlinClock("01:00:00")

        val topHours = listOf(OFF, OFF, OFF, OFF)
        val bottomHours = listOf(RED, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_2_hour_light() {
        val result = berlinClock.getBerlinClock("02:00:00")

        val topHours = listOf(OFF, OFF, OFF, OFF)
        val bottomHours = listOf(RED, RED, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_3_hour_light() {
        val result = berlinClock.getBerlinClock("03:00:00")

        val topHours = listOf(OFF, OFF, OFF, OFF)
        val bottomHours = listOf(RED, RED, RED, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_4_hour_light() {
        val result = berlinClock.getBerlinClock("04:00:00")

        val topHours = listOf(OFF, OFF, OFF, OFF)
        val bottomHours = listOf(RED, RED, RED, RED)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_5_hour_light() {
        val result = berlinClock.getBerlinClock("05:00:00")

        val topHours = listOf(RED, OFF, OFF, OFF)
        val bottomHours = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_7_hour_light() {
        val result = berlinClock.getBerlinClock("07:00:00")

        val topHours = listOf(RED, OFF, OFF, OFF)
        val bottomHours = listOf(RED, RED, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_10_hour_light() {
        val result = berlinClock.getBerlinClock("10:00:00")

        val topHours = listOf(RED, RED, OFF, OFF)
        val bottomHours = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_15_hour_light() {
        val result = berlinClock.getBerlinClock("15:00:00")

        val topHours = listOf(RED, RED, RED, OFF)
        val bottomHours = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_19_hour_light() {
        val result = berlinClock.getBerlinClock("19:00:00")

        val topHours = listOf(RED, RED, RED, OFF)
        val bottomHours = listOf(RED, RED, RED, RED)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_20_hour_light() {
        val result = berlinClock.getBerlinClock("20:00:00")

        val topHours = listOf(RED, RED, RED, RED)
        val bottomHours = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_23_hour_light() {
        val result = berlinClock.getBerlinClock("23:00:00")

        val topHours = listOf(RED, RED, RED, RED)
        val bottomHours = listOf(RED, RED, RED, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes())

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_3_11_45_time_light() {
        val result = berlinClock.getBerlinClock("03:11:45")

        val topHours = listOf(OFF, OFF, OFF, OFF)
        val bottomHours = listOf(RED, RED, RED, OFF)
        val topMinutes = listOf(YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(OFF, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_8_24_1_time_light() {
        val result = berlinClock.getBerlinClock("08:24:01")

        val topHours = listOf(RED, OFF, OFF, OFF)
        val bottomHours = listOf(RED, RED, RED, OFF)
        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, YELLOW)

        val expectedResult = BerlinClockModel(OFF, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_11_11_11_time_light() {
        val result = berlinClock.getBerlinClock("11:11:11")

        val topHours = listOf(RED, RED, OFF, OFF)
        val bottomHours = listOf(RED, OFF, OFF, OFF)
        val topMinutes = listOf(YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(OFF, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_12_3_58_time_light() {
        val result = berlinClock.getBerlinClock("12:03:58")

        val topHours = listOf(RED, RED, OFF, OFF)
        val bottomHours = listOf(RED, RED, OFF, OFF)
        val topMinutes = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_15_30_30_time_light() {
        val result = berlinClock.getBerlinClock("15:30:30")

        val topHours = listOf(RED, RED, RED, OFF)
        val bottomHours = listOf(OFF, OFF, OFF, OFF)
        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF)
        val bottomMinutes = listOf(OFF, OFF, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_22_42_28_time_light() {
        val result = berlinClock.getBerlinClock("22:42:28")

        val topHours = listOf(RED, RED, RED, RED)
        val bottomHours = listOf(RED, RED, OFF, OFF)
        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, OFF, OFF, OFF)
        val bottomMinutes = listOf(YELLOW, YELLOW, OFF, OFF)

        val expectedResult = BerlinClockModel(YELLOW, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }

    @Test
    fun test_23_59_59_time_light() {
        val result = berlinClock.getBerlinClock("23:59:59")

        val topHours = listOf(RED, RED, RED, RED)
        val bottomHours = listOf(RED, RED, RED, OFF)
        val topMinutes = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        val bottomMinutes = listOf(YELLOW, YELLOW, YELLOW, YELLOW)

        val expectedResult = BerlinClockModel(OFF, Hours(topHours, bottomHours), Minutes(topMinutes, bottomMinutes))

        assertEquals(expectedResult, result)
    }
}