package com.dfr.inspirationquotes.domain.usecase;

import com.dfr.inspirationquotes.domain.model.QuoteDTO;
import com.dfr.inspirationquotes.domain.repository.QuoteRemoteRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetRandomQuoteUseCaseImpl implements GetRandomQuoteUseCase {


    private final QuoteRemoteRepository quoteRemoteRepository;

    @Inject
    public GetRandomQuoteUseCaseImpl(QuoteRemoteRepository quoteRemoteRepository) {
        this.quoteRemoteRepository = quoteRemoteRepository;
    }

    @Override
    public Observable<QuoteDTO> getRandomQuote() {
        return quoteRemoteRepository.getRandomQuote();
    }
}
