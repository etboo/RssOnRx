package com.it_step.rssonrxsample.services.api;


import com.it_step.rssonrxsample.model.RssFeed;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TechCrunchApi {

    @GET("/TechCrunch/social")
    Observable<RssFeed> getItems();
}
