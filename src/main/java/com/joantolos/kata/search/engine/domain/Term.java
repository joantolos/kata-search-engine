package com.joantolos.kata.search.engine.domain;

public class Term {

    private String term;
    private Integer numberOfTimes;

    public Term(String term, Integer numberOfTimes) {
        this.term = term;
        this.numberOfTimes = numberOfTimes;
    }

    public String getTerm() {
        return term;
    }

    public Integer getNumberOfTimes() {
        return numberOfTimes;
    }
}
