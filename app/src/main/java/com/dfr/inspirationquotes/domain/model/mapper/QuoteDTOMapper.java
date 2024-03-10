package com.dfr.inspirationquotes.domain.model.mapper;

import com.dfr.inspirationquotes.data.model.QuoteData;
import com.dfr.inspirationquotes.domain.model.QuoteDTO;

public class QuoteDTOMapper {

    public static QuoteDTO fromQuoteData(QuoteData quote) {
        return new QuoteDTO(quote.getId(), quote.getAuthor(), quote.getQuote());
    }
}
