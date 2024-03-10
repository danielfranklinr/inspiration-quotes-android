package com.dfr.inspirationquotes.data.network.service;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@ApplicationContext Context context) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(com.dfr.inspirationquotes.R.string.service_quote_api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    public QuoteApiService provideTaskApiService(Retrofit retrofit) {
        return retrofit.create(QuoteApiService.class);
    }
}