package com.example.week5_unit_and_instrumentaion_tests

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4ClassRunner::class)
class RegistrationFragmentTest{
    @Test
    fun test_resistration_fragment() {
       // val fragmentArgs = bundleOf(“selectedListItem” to 0)
        val scenario = launchFragmentInContainer<Registration>(themeResId = R.style.Base_Theme_MaterialComponents_Light) //This line launches the fragment named Registration
       // scenario.moveToState(Lifecycle.State.RESUMED)
        //scenario.recreate()

        onView(withId(R.id.registration_form_root)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


    }
}




//
//@Test fun testEventFragment() {
//    val scenario = launchFragmentInContainer<HomeFragment>(themeResId = R.style.Base_Theme_MaterialComponents_Light)
//    Espresso.onView(ViewMatchers.withId(R.id.searchView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//}