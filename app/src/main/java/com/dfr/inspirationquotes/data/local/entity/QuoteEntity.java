package com.dfr.inspirationquotes.data.local.entity;

public class QuoteEntity {

    String id;
    String author;
    String quote;

    public QuoteEntity(String id, String author, String quote) {
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
