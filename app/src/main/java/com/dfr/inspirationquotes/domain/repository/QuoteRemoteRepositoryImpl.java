package com.dfr.inspirationquotes.domain.repository;

import com.dfr.inspirationquotes.data.datasource.QuoteRemoteDatasource;
import com.dfr.inspirationquotes.data.network.service.QuoteApiService;
import com.dfr.inspirationquotes.domain.model.QuoteDTO;
import com.dfr.inspirationquotes.domain.model.mapper.QuoteDTOMapper;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class QuoteRemoteRepositoryImpl implements QuoteRemoteRepository {

    private final QuoteRemoteDatasource quoteRemoteDatasource;


    @Inject
    public QuoteRemoteRepositoryImpl(QuoteRemoteDatasource quoteRemoteDatasource) {
        this.quoteRemoteDatasource = quoteRemoteDatasource;
    }


    @Override
    public Observable<QuoteDTO> getRandomQuote() {
        return quoteRemoteDatasource.getRandomQuote().map(QuoteDTOMapper::fromQuoteData);
    }
}
