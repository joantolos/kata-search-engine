package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;
import com.joantolos.kata.search.engine.domain.SearchResult;
import com.joantolos.kata.search.engine.domain.Term;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchEngineService {

    private List<AppFile> files;

    public SearchEngineService(List<AppFile> files) {
        this.files = files;
    }

    public SearchResult search(String toSearch) {
        files.forEach(appFile -> {
            Matcher matcher = Pattern.compile("\\b(" +
                    StringUtils.join(Arrays.stream(toSearch.split(" "))
                            .map(String::new)
                            .collect(Collectors.toList()), "|")
                    + ")\\b").matcher(appFile.getContent());
            appFile.setTerms(this.getTerms(matcher));
        });

        return new SearchResult(toSearch, files.size(), files);
    }

    private List<Term> getTerms(Matcher matcher) {
        return this.getCounts(matcher).entrySet()
                .stream()
                .map(e -> new Term(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> getCounts(Matcher matcher) {
        Map<String, Integer> count = new HashMap<>();

        while (matcher.find()) {
            String term = matcher.group(1);
            if(count.get(term) != null) {
                count.replace(term, count.get(term) + 1);
            } else {
                count.put(term, 1);
            }
        }
        return count;
    }
}
