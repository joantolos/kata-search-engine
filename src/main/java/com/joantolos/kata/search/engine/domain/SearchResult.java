package com.joantolos.kata.search.engine.domain;

import java.util.List;

public class SearchResult {

    private List<AppFile> appFiles;
    private String head;

    public SearchResult(String term, Integer totalFiles, List<AppFile> appFiles) {
        this.appFiles = appFiles;
        this.head = "Search results for the term '" + term + "' into " + totalFiles + " files.";
    }

    public String toString(){
        return this.head + appFiles.stream()
                .map(appFile -> "\n\nThe file '" +
                        appFile.getName() +
                        appFile.getTerms().stream()
                                .map(Term::toString)
                                .reduce("", String::concat))
                .reduce("", String::concat);
    }
}
