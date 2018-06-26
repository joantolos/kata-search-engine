package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class LoaderService {

    private String path;

    public LoaderService(String path) {
        this.path = path;
    }

    public List<AppFile> load() throws FileLoadingException {
        try {
            return Files.walk(Paths.get(this.path))
                    .filter(Files::isRegularFile)
                    .map(currentPath -> new AppFile(currentPath.getFileName().toString(), currentPath.toFile()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileLoadingException();
        }
    }
}
