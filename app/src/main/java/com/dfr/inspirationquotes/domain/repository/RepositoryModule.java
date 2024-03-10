package com.dfr.inspirationquotes.domain.repository;

import com.dfr.inspirationquotes.data.datasource.QuoteRemoteDatasource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Singleton
    @Provides
    public QuoteRemoteRepository providesQuoteRemoteRepository(QuoteRemoteDatasource quoteRemoteDatasource) {
        return new QuoteRemoteRepositoryImpl(quoteRemoteDatasource);
    }

}
