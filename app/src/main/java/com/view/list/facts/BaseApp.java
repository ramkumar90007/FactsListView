package com.view.list.facts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.view.list.facts.feedlist.DaggerFeed;
import com.view.list.facts.feedlist.Feed;
import com.view.list.facts.networking.NetworkModule;

import java.io.File;

/**
 * Created by ramkumarpachaiyappan on 18/02/18.
 */

public abstract class BaseApp extends AppCompatActivity {
    Feed feed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        feed = DaggerFeed.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Feed getFeeds() {
        return feed;
    }


}