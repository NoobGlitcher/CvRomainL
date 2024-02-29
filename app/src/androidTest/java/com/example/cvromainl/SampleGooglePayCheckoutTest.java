package com.example.cvromainl;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import com.example.cvromainl.R;
import com.example.cvromainl.View.CheckoutActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Instrumented test, which will execute on an Android device.
 * <p>
 * See <a href="http://d.android.com/tools/testing">testing documentation</a>.
 */
public class SampleGooglePayCheckoutTest {
    private static final String GOOGLE_PAY_SHEET_PACKAGE = "com.google.android.gms";

    @Rule
    public ActivityScenarioRule<CheckoutActivity> activityRule =
            new ActivityScenarioRule<>(CheckoutActivity.class);

    private UiDevice device;

    @Before
    public void setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testDummyVisaCardPayment() throws UiObjectNotFoundException {

        // [Espresso] Click on pay with Google Pay
        Espresso.onView(ViewMatchers.withId(R.id.googlePayButton)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.googlePayButton)).perform(ViewActions.click());

        // [UIAutomator] Wait for payment sheet to come up
        device.waitForWindowUpdate(GOOGLE_PAY_SHEET_PACKAGE, 0);

        // [UIAutomator] Click on the card chooser
        final UiObject paymentMethodSelectorArrow = device.findObject(new UiSelector()
                .className("android.widget.ImageView")
                .descriptionContains("Show list of payment methods."));
        paymentMethodSelectorArrow.click();

        // [UIAutomator] Change the card
        final UiSelector targetCardSelector = new UiSelector()
                .className("android.widget.TextView")
                .textContains("Visa");

        final UiScrollable cardList = new UiScrollable(
                new UiSelector().className("android.widget.ScrollView"));
        cardList.scrollIntoView(targetCardSelector);
        device.findObject(targetCardSelector).click();

        // [UIAutomator] Confirm selection and back to the app
        final UiObject continueButton = device.findObject(new UiSelector()
                .className("android.widget.Button")
                .text("Continue"));
        continueButton.click();

        // [Espresso] Confirm that the success screen is visible
        Espresso.onView(ViewMatchers.withId(R.id.success_activity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}