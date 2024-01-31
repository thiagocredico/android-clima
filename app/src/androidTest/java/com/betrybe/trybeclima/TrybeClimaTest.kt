package com.betrybe.trybeclima

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.betrybe.trybeclima.ui.views.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TrybeClimaTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testGetFortalezaWeather(){

        onView(withId(R.id.main_text_field))
            .perform(typeText("Fortaleza"))

        onView(withId(R.id.button))
            .perform(click())


        Thread.sleep(5000)
    }

}