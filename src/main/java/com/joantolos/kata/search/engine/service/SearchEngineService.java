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

    public SearchEngineService(List<AppFile> files) throws IllegalArgumentException {
        this.files = files;
    }

    public SearchResult search(String toSearch) {

        for(AppFile appFile : files){
            String patternString =
                    "\\b(" +
                            StringUtils.join(Arrays.stream(toSearch.split(" "))
                                    .map(String::new)
                                    .collect(Collectors.toList()), "|")
                            + ")\\b";

            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(appFile.getContent());
            Map<String, Integer> count = new HashMap<>();

            while (matcher.find()) {
                String term = matcher.group(1);
                if(count.get(term) != null) {
                    count.replace(term, count.get(term) + 1);
                } else {
                    count.put(term, 1);
                }
            }
            List<Term> terms = new ArrayList<>();
            count.forEach((k, v) -> terms.add(new Term(k, v)));
            appFile.setTerms(terms);
        }

        return new SearchResult(toSearch, files.size(), files);
    }
}
