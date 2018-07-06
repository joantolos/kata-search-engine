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

    public String toString(){
        StringBuilder result = new StringBuilder("Search results for the term '" +
                this.term +
                "' into " +
                this.totalFiles +
                " files.");

        for(AppFile appFile : appFiles) {
            result.append("\nThe file: '").append(appFile.getName());
            for(Term term : appFile.getTerms()) {
                result.append("\tContains the word '").append(term.getTerm()).append("' ").append(term.getNumberOfTimes()).append(" times.");
            }
        }

        return result.toString();
    }
}
