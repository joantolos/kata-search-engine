package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;
import com.joantolos.kata.search.engine.domain.SearchResult;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchEngineService {

    private List<AppFile> files;

    public SearchEngineService(List<AppFile> files) throws IllegalArgumentException {
        this.files = files;
    }

    public SearchResult search(String toSearch) {
        List<String> words = Arrays.stream(toSearch.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        String patternString = "\\b(" + StringUtils.join(words, "|") + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher("This is a text that contains the word lili see?");

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        return new SearchResult(toSearch, files.size());
    }
}
