package com.example.autotestexample;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testButtonClicksUpdatesTextView()
            throws InterruptedException {
        int n = 10;
        // Perform clicks action on the button
        for (int i = 0; i < n; i += 1) {
            onView(withId(R.id.button)).perform(click());
        }

        // Sleep to verify the test result
        Thread.sleep(1_000);

        // Verify that the TextView text changes to the expected value
        String expected = String.valueOf(n);
        onView(withId(R.id.textView)).check(matches(withText(expected)));

    }
}
