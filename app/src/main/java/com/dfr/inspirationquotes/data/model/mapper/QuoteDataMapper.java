package com.dfr.inspirationquotes.data.model.mapper;

import com.dfr.inspirationquotes.data.local.entity.QuoteEntity;
import com.dfr.inspirationquotes.data.model.QuoteData;
import com.dfr.inspirationquotes.data.network.model.QuoteService;

public class QuoteDataMapper {

    public static QuoteData fromQuoteService(QuoteService quote) {
        return new QuoteData(quote.getId(), quote.getAuthor(), quote.getQuote());
    }

    public static QuoteData fromQuoteEntity(QuoteEntity quote) {
        return new QuoteData(quote.getId(), quote.getAuthor(), quote.getQuote());
    }
}
