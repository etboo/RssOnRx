package com.it_step.rssonrxsample.services;

import com.it_step.rssonrxsample.model.RssFeed;
import com.it_step.rssonrxsample.services.api.TechCrunchApi;

import io.reactivex.Observable;


public class RssService {

    private TechCrunchApi api;

    public RssService(TechCrunchApi api) {
        this.api = api;
    }

    public Observable<RssFeed> getItems() {
        return api.getItems();
        //TODO: change subscription and observer threads!!

    }
}
