package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class IncrementTest {
    @Rule public ActivityTestRule<OrderActivity> orderActivityActivityTestRule =
            new ActivityTestRule<>(OrderActivity.class);

    @Test
    public void incrementPriceText(){
        //find tje view
        //perform action
        onView(withId(R.id.increment_button)).perform(click());

        //assertion
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));

    }

}
