package com.joantolos.kata.search.engine.domain;

import java.util.List;

public class AppFile {

    private String name;
    private String content;
    private List<Term> terms;

    public AppFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }
}
