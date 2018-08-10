package com.joantolos.kata.search.engine.domain;

public class Term {

    private String term;
    private Integer numberOfTimes;

    public Term(String term, Integer numberOfTimes) {
        this.term = term;
        this.numberOfTimes = numberOfTimes;
    }

    public String toString() {
        return "\n\tContains the word '" + this.term + "' " + this.numberOfTimes + " times.";
    }
}
