package com.dfr.inspirationquotes.domain.usecase;

import com.dfr.inspirationquotes.domain.model.QuoteDTO;

import io.reactivex.rxjava3.core.Observable;

public interface GetRandomQuoteUseCase {

    Observable<QuoteDTO> getRandomQuote();
}
