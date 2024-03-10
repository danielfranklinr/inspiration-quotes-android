package com.dfr.inspirationquotes.data.datasource;

import com.dfr.inspirationquotes.data.network.service.QuoteApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatasourceModule {

    @Singleton
    @Provides
    public QuoteRemoteDatasource providesQuoteRemoteDatasource(QuoteApiService quoteApiService) {
        return new QuoteRemoteDatasourceImpl(quoteApiService);
    }

}
