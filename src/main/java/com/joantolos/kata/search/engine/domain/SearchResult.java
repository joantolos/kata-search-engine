package com.joantolos.kata.search.engine.domain;

import java.util.List;

public class SearchResult {

    private String term;
    private Integer totalFiles;
    private List<AppFile> appFiles;

    public SearchResult(String term, Integer totalFiles, List<AppFile> appFiles) {
        this.term = term;
        this.totalFiles = totalFiles;
        this.appFiles = appFiles;
    }

    public String getTerm() {
        return term;
    }

    public Integer getTotalFiles() {
        return totalFiles;
    }

    public List<AppFile> getAppFiles() {
        return appFiles;
    }
}
