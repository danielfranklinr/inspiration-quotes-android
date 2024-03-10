package com.dfr.inspirationquotes.data.datasource;

import com.dfr.inspirationquotes.data.model.QuoteData;
import com.dfr.inspirationquotes.data.model.mapper.QuoteDataMapper;
import com.dfr.inspirationquotes.data.network.service.QuoteApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class QuoteRemoteDatasourceImpl implements QuoteRemoteDatasource {

    private final QuoteApiService quoteApiService;

    @Inject
    public QuoteRemoteDatasourceImpl(QuoteApiService quoteApiService) {
        this.quoteApiService = quoteApiService;
    }

    @Override
    public Observable<QuoteData> getRandomQuote() {

        return quoteApiService.fetchRandomQuote()
                .map(QuoteDataMapper::fromQuoteService);
    }
}
