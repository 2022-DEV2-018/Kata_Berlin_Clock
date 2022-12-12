package com.kata.berlinclock

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import org.koin.core.component.KoinComponent

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class BerlinClockUITests : KoinComponent {

    @Before
    fun setUp() {
        ActivityScenario.launch(BerlinClockActivity::class.java)
    }

    @Test
    fun test_are_all_views_visible() {
        onView(withId(R.id.view_seconds)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_top_hours)).check(matches(hasChildCount(4)))
        onView(withId(R.id.recyclerview_bottom_hours)).check(matches(hasChildCount(4)))
        onView(withId(R.id.recyclerview_top_minutes)).check(matches(hasChildCount(11)))
        onView(withId(R.id.recyclerview_bottom_minutes)).check(matches(hasChildCount(4)))
        onView(withId(R.id.textview_clock)).check(matches((CoreMatchers.not(withText("")))))
    }
}