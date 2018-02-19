package com.view.list.utils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Created by ramkumarpachaiyappan on 19/02/18.
 */

public class RoboUtils {
    public static void seesViewWithId(int id) {
        onView(withId(id)).check(matches(isDisplayed()));
    }

    public static void doesNotSeesViewWithId(int id) {
        onView(withId(id)).check(matches(not(isDisplayed())));
    }
}
