package com.dfr.inspirationquotes.data.network.model;

import com.google.gson.annotations.SerializedName;

public class QuoteService {
    @SerializedName("id")
    String id;

    @SerializedName("author")
    String author;

    @SerializedName("quote")
    String quote;

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
