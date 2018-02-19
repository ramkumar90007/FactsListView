package com.view.list.facts;



import com.view.list.facts.model.NewsFeedList;
import com.view.list.facts.networking.NetworkError;
import com.view.list.facts.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ramkumarpachaiyappan on 18/02/18.
 */

public class FactsPresenter {
    private final Service service;
    private final FactsView view;
    private CompositeSubscription subscriptions;

    public FactsPresenter(Service service, FactsView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getNewsFeedList() {
        view.showWait();

        Subscription subscription = service.getNewsFeedList(new Service.GetNewsFeedListCallback() {
            @Override
            public void onSuccess(NewsFeedList newsFeedListResponse) {
                view.removeWait();
                view.getNewsFeedListSuccess(newsFeedListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}


