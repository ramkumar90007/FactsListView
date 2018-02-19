package com.view.list.Robot;

import com.view.list.facts.R;
import com.view.list.utils.RoboUtils;

/**
 * Created by ramkumarpachaiyappan on 19/02/18.
 */

public class FactsListRobot {
    public static class Eyes {

        public Eyes seesToolbar() {
            RoboUtils.seesViewWithId(R.id.toolbar);
            return this;
        }
        public Eyes seesSwipeRefreshLayout() {
            RoboUtils.seesViewWithId(R.id.swipeRefreshLayout);
            return this;
        }

        public Eyes seesListRecyclerView() {
            RoboUtils.seesViewWithId(R.id.list);
            return this;
        }
        public Eyes doesNotSeeToolbar() {
            RoboUtils.doesNotSeesViewWithId(R.id.toolbar);
            return this;
        }
        public Eyes doesNotSeeListRecyclerView() {
            RoboUtils.doesNotSeesViewWithId(R.id.list);
            return this;
        }


    }
}
