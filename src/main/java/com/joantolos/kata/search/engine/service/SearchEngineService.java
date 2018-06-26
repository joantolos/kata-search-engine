package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;
import com.joantolos.kata.search.engine.domain.SearchResult;
import com.joantolos.kata.search.engine.exception.FileLoadingException;

import java.util.List;

public class SearchEngineService {

    private List<AppFile> files;

    public SearchEngineService(String path) throws IllegalArgumentException, FileLoadingException {
        this.files = new LoaderService(path).load();
    }

    public SearchResult search(String toSearch) {
        return new SearchResult(toSearch, files.size());
    }
}
