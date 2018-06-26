package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;

import java.util.ArrayList;
import java.util.List;

public class LoaderService {

    private String path;

    public LoaderService(String path) {
        this.path = path;
    }

    public List<AppFile> load() {
        return new ArrayList<>();
    }
}
