package com.dfr.inspirationquotes.data.datasource;

import android.util.Pair;

import com.dfr.inspirationquotes.data.model.QuoteData;
import com.dfr.inspirationquotes.data.model.mapper.QuoteDataMapper;
import com.dfr.inspirationquotes.data.network.service.QuoteApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class QuoteRemoteDatasourceImpl implements QuoteRemoteDatasource {

    private final QuoteApiService quoteApiService;

    private final int MAX_RETRIES = 3;
    private final int RETRY_DELAY_SECONDS = 3;

    @Inject
    public QuoteRemoteDatasourceImpl(QuoteApiService quoteApiService) {
        this.quoteApiService = quoteApiService;
    }

    @Override
    public Observable<QuoteData> getRandomQuote() {

        return quoteApiService.fetchRandomQuote()
                .subscribeOn(Schedulers.io())
                .retryWhen(error -> error
                        .zipWith(Observable.range(1, MAX_RETRIES),
                                Pair::new)
                        .flatMap(pair -> {
                                    Throwable throwable = pair.first;
                                    Integer attempt = pair.second;
                                    if (attempt <= MAX_RETRIES
                                            && throwable instanceof HttpException) {
                                        return Observable.timer((long) attempt * RETRY_DELAY_SECONDS, TimeUnit.SECONDS);
                                    } else {
                                        return Observable.error(throwable);

                                    }
                                }
                        )
                )
                .map(QuoteDataMapper::fromQuoteService);

    }
}
