package com.dfr.inspirationquotes.domain.repository;

import com.dfr.inspirationquotes.domain.model.QuoteDTO;

import io.reactivex.rxjava3.core.Observable;

public interface QuoteRemoteRepository {

    Observable<QuoteDTO> getRandomQuote();

}
