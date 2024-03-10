package com.dfr.inspirationquotes.presentation.viewmodel;

import androidx.lifecycle.ViewModel;

import com.dfr.inspirationquotes.domain.model.QuoteDTO;
import com.dfr.inspirationquotes.domain.usecase.GetRandomQuoteUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Observable;


@HiltViewModel
public class RandomQuoteViewModel extends ViewModel {

    private final GetRandomQuoteUseCase getRandomQuoteUseCase;

    @Inject
    public RandomQuoteViewModel(GetRandomQuoteUseCase getRandomQuoteUseCase) {
        this.getRandomQuoteUseCase = getRandomQuoteUseCase;
    }


    public Observable<QuoteDTO> getRandomQuote() {
        return getRandomQuoteUseCase.getRandomQuote();
    }
}
