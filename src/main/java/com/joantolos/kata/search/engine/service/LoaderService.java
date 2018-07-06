package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.domain.AppFile;
import com.joantolos.kata.search.engine.exception.ErrorMessage;
import com.joantolos.kata.search.engine.ui.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class LoaderService {

    private String path;
    private Console console;

    public LoaderService(String path, Console console) {
        this.path = path;
        this.console = console;
    }

    public List<AppFile> load() {
        try {
            return Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(path -> new AppFile(path.getFileName().toString(), getContent(path)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            this.console.print(ErrorMessage.FILE_LOADING);
            return null;
        }
    }

    protected String getContent(Path path) {
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException | NullPointerException e) {
            this.console.print(ErrorMessage.FILE_LOADING);
            return null;
        }
    }

}
