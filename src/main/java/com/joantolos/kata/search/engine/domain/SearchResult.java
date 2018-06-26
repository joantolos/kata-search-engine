package com.joantolos.kata.search.engine.domain;

public class SearchResult {

    private String term;
    private Integer totalFiles;

    public SearchResult(String term, Integer totalFiles) {
        this.term = term;
        this.totalFiles = totalFiles;
    }

    public String getTerm() {
        return term;
    }

    public Integer getTotalFiles() {
        return totalFiles;
    }
}
