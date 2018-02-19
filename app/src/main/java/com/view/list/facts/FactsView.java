package com.view.list.facts;


import com.view.list.facts.model.NewsFeedList;

/**
 * Created by ramkumarpachaiyappan on 18/02/18.
 */

public interface FactsView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getNewsFeedListSuccess(NewsFeedList newsFeedListResponse);

}
