package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(JUnit4.class)
public class OrderActivityT {
@Rule
public ActivityTestRule<OrderActivity> ordActivity =
        new ActivityTestRule<>(OrderActivity.class);
@Test
public void testDecrement(){
    onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
    onView(withId(R.id.decrement_button)).perform(click());
    onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
    onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));
}
}
