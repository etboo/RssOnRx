package com.it_step.rssonrxsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.it_step.rssonrxsample.services.RssService;
import com.it_step.rssonrxsample.services.api.TechCrunchApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String RSS_LINK = "http://feeds.feedburner.com/";

    private RssService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = new RssService(buildApi());


    }

    private TechCrunchApi buildApi() {
        return provideRetrofit().create(TechCrunchApi.class);
    }

    private Retrofit provideRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        return new Retrofit.Builder()
                .baseUrl(RSS_LINK)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
