package com.view.list.facts.networking;




import com.view.list.facts.model.NewsFeedList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ramkumar Pachaiyappan on 19/02/18.
 */
public interface NetworkService {

    @GET("facts.json")
    Observable<NewsFeedList> getNewsFeedList();

}
