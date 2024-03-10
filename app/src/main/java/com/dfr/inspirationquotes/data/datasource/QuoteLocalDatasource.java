package com.dfr.inspirationquotes.data.datasource;

import com.dfr.inspirationquotes.data.model.QuoteData;

import io.reactivex.rxjava3.core.Observable;

public interface QuoteLocalDatasource {

    public abstract Observable<QuoteData> getRandomQuote();
}
