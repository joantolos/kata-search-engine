package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;

import java.util.List;

public class SearchEngineService {

    private List<AppFile> files;

    public SearchEngineService(String path) throws IllegalArgumentException, FileLoadingException {
        new LoaderService(path).load();
    }

}
