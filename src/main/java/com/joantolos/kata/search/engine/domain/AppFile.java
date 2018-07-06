package com.joantolos.kata.search.engine.domain;

public class AppFile {

    private String name;
    private String content;

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

}
