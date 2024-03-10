package com.dfr.inspirationquotes.domain.model;

public class QuoteDTO {

    String id;
    String author;
    String quote;

    public QuoteDTO(String id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }


}
