package com.view.list.facts.feedlist;


import com.view.list.facts.FactsActivity;
import com.view.list.facts.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ramkumarpachaiyappan on 18/02/18.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Feed {
    void inject(FactsActivity factsActivity);
}
