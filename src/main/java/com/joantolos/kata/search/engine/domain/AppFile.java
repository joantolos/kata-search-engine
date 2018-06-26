package com.joantolos.kata.search.engine.domain;

import java.io.File;

public class AppFile {

    private String name;
    private File content;

    public AppFile(String name, File content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public File getContent() {
        return content;
    }
}
