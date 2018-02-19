package com.view.list.facts;

import android.app.Application;

import com.view.list.facts.utils.ConnectivityReceiver;

/**
 * Created by ramkumarpachaiyappan on 19/02/18.
 */

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}

