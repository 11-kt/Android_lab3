package com.labs.task2_navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId

private fun openAboutViaBottomNav() {
    onView(withId(R.id.nav_view)).perform(click())
}

fun openAbout() = openAboutViaBottomNav()