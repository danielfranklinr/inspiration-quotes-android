package com.dfr.inspirationquotes.domain.usecase;

import com.dfr.inspirationquotes.data.datasource.QuoteRemoteDatasource;
import com.dfr.inspirationquotes.domain.repository.QuoteRemoteRepository;
import com.dfr.inspirationquotes.domain.repository.QuoteRemoteRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {

    @Singleton
    @Provides
    public GetRandomQuoteUseCase providesGetRandomQuoteUseCase(QuoteRemoteRepository quoteRemoteRepository) {
        return new GetRandomQuoteUseCaseImpl(quoteRemoteRepository);
    }

}

