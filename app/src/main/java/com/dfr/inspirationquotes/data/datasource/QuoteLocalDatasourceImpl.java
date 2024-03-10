package com.dfr.inspirationquotes.data.datasource;

import com.dfr.inspirationquotes.data.model.QuoteData;

import io.reactivex.rxjava3.core.Observable;

public class QuoteLocalDatasourceImpl implements QuoteLocalDatasource {

    @Override
    public Observable<QuoteData> getRandomQuote() {

        return null;
    }
}
