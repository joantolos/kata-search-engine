package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;
import com.joantolos.kata.search.engine.exception.FileLoadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
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
                    .map(currentPath -> {
                        try {
                            return new AppFile(
                                    currentPath.getFileName().toString(),
                                    new String(Files.readAllBytes(currentPath)));
                        } catch (IOException ignored) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileLoadingException();
        }
    }

}
