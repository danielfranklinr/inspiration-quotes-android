package com.dfr.inspirationquotes.data.network.service;

import com.dfr.inspirationquotes.data.network.model.QuoteService;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface QuoteApiService {

    @GET("quote/random")
    Observable<QuoteService> fetchRandomQuote();
}
