package com.example.android.teatime;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class ActivityScreenTest {
    @Rule
    public ActivityTestRule<MenuActivity> testMenu = new ActivityTestRule<>(MenuActivity.class);
    private IdlingResource mIdlingResource;
    @Before
    public void registerIdlingResource() {
        mIdlingResource = testMenu.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
//        Espresso.registerIdlingResources(mIdlingResource);
        IdlingRegistry.getInstance().register(mIdlingResource);
    }
    @Test
    public void onClickOnGrid_openOrderActivity_withSameName(){

        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Green Tea")));
    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
//            Espresso.unregisterIdlingResources(mIdlingResource);
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }
}
