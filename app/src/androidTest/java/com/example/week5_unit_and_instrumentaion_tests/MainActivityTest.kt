package com.example.week5_unit_and_instrumentaion_tests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get: Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_main_activity_launch() {
        //Testing if my main activity launches...

        //val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launches the activity
        //onView(withId(R.id.main_activity)).check(matches(isDisplayed()))  // checks if the activity is  correctly in view (displayed)

        Espresso.onView(ViewMatchers.withId(R.id.main_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_bottom_navigation_bar_if_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launches the activity

        Espresso.onView(ViewMatchers.withId(R.id.buttom_nav_bar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // Tests if the bottom navigation bar is visible
    }

    @Test
    fun test_registration_button_if_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launches the activity

        Espresso.onView(ViewMatchers.withId(R.id.registration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) //Tests if the registration button on the nav bar is visible
    }

    @Test
    fun test_details_button_if_displayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launches the activity

        Espresso.onView(ViewMatchers.withId(R.id.account_details))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) //Tests if the details  button on the nav bar is visible
    }

    @Test
    fun test_frame_layout_if_displayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launches the activity

        Espresso.onView(ViewMatchers.withId(R.id.my_fragment_container))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))  //Tests if the frame layout in the main activity is visible
    }
}














