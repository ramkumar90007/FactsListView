package com.view.list.facts.networking;

import com.view.list.facts.model.NewsFeedList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ramkumar Pachaiyappan on 19/02/18.
 */
public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getNewsFeedList(final GetNewsFeedListCallback callback) {

        return networkService.getNewsFeedList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends NewsFeedList>>() {
                    @Override
                    public Observable<? extends NewsFeedList> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<NewsFeedList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(NewsFeedList newsfeedlistResponse) {
                        callback.onSuccess(newsfeedlistResponse);

                    }
                });
    }

    public interface GetNewsFeedListCallback{
        void onSuccess(NewsFeedList newsfeedlistResponse);

        void onError(NetworkError networkError);
    }
}
