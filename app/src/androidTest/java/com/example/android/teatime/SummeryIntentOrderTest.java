package com.example.android.teatime;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.core.internal.deps.guava.collect.Iterables;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class SummeryIntentOrderTest {
    @Rule
    IntentsTestRule<OrderSummaryActivity> orderSummaryActivityIntentsTestRule =
            new IntentsTestRule<>(OrderSummaryActivity.class);

    @Before
    public void stubAllIntent(){
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK,null));
    }

    @Test
    public void testIntentEmailSent(){
        onView(withId(R.id.send_email_button)).perform(click());
        intended(allOf(hasAction(Intent.ACTION_SENDTO),
                hasExtra(Intent.EXTRA_TEXT,"I just ordered a delicious tea from TeaTime. Next time you are craving a tea, check them out!")));



    }
}
