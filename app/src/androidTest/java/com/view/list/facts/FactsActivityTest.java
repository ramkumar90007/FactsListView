package com.view.list.facts;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static com.view.list.facts.TestUtils.withRecyclerView;

/**
 * Created by Ramkumar on 2/19/18.
 */

public class FactsActivityTest extends ActivityInstrumentationTestCase2<FactsActivity> {

        public FactsActivityTest() {
                super(FactsActivity.class);
        }

        @Override
        protected void setUp() throws Exception {

                getActivity();
        }

        public void testItemClick() {

                onView(withRecyclerView(R.id.list).atPosition(1)).perform(click());
        }



}
