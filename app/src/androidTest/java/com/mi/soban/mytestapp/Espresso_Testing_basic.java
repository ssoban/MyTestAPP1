package com.mi.soban.mytestapp;

import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.getText;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(AndroidJUnit4.class)
public class Espresso_Testing_basic {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void TC01VerifyOnScreenObjectsActivityLaunch() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.name)).check(matches(isDisplayed()));

        onView(withId(R.id.email)).check(matches(isDisplayed()));

        onView(withId(R.id.phonenumber)).check(matches(isDisplayed()));

        onView(withId(R.id.submit)).check(matches(isDisplayed()));

        onView(withId(R.id.TC)).check(matches(isDisplayed()));

        onView(withId(R.id.fab)).check(matches(isDisplayed()));

        onView(withId(R.id.fab)).perform(click());
        Thread.sleep(5000);
    }

    @Test
    public void TC02VerifySignupMessage() throws InterruptedException {


        String personname="soban";
        String personphonenumber="9090909090";
        String emailadd="xyz2gmail.com";

        Thread.sleep(2000);
        // Type text and then press the button.
        onView(withId(R.id.name)).perform(click()).perform(typeText(personname), closeSoftKeyboard());
        Thread.sleep(2000);
        // Check that the text was changed.
        onView(withId(R.id.name))
                .check(matches(withText(personname)));

        Thread.sleep(5000);
        // Type text and then press the button.
        onView(withId(R.id.phonenumber)).perform(click())
                .perform(typeText(personphonenumber), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.phonenumber))
                .check(matches(withText(personphonenumber)));

        Thread.sleep(5000);
        // Type text and then press the button.
        onView(withId(R.id.email)).perform(click())
                .perform(typeText(emailadd), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.email))
                .check(matches(withText(emailadd)));
        Thread.sleep(5000);

        onView(withId(R.id.submit)).perform(click());

        onView(withText("Hi, I am " + personname + "I can be reach at " + personphonenumber +"or" +emailadd));

        Thread.sleep(5000);
    }


    @Test
    public void TC03VerifyclickButton() throws InterruptedException {

        Thread.sleep(5000);
        onView(withId(R.id.TC)).perform(click());
        // Selects the WebView in your layout.

        // matcher to select a given WebView, onWebView(withId(R.id.web_view)).
        onWebView()
                // Find the input element by ID
                .withElement(findElement(Locator.ID, "text_input"))


                // Verify that the response page contains the  text
                .check(webMatches(getText(), containsString("Hello Truecaller")));

    }





}
