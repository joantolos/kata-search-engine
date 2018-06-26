package com.joantolos.kata.search.engine.domain;

public class SearchResult {

    public String getTerm() {
        return term;
    }

    private String term;

    public SearchResult(String term) {
        this.term = term;
    }
}
