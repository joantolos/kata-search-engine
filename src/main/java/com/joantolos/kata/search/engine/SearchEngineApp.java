package com.joantolos.kata.search.engine;

import com.joantolos.kata.search.engine.exception.FileLoadingException;
import com.joantolos.kata.search.engine.service.ArgumentParser;
import com.joantolos.kata.search.engine.service.SearchEngineService;
import com.joantolos.kata.search.engine.ui.Console;

import java.util.Scanner;

public class SearchEngineApp {

    public static void main(String[] args) {
        Console console = new Console();
        SearchEngineService searchEngineService;

        try {
            String folder = new ArgumentParser(args).getFolder();
            searchEngineService = new SearchEngineService(folder);
            console.prompt(folder);
            Scanner keyboard = new Scanner(System.in);
            String toSearch;
            do {
                console.print("\nsearch > ");
                toSearch = keyboard.nextLine();
                console.printSearchResult(searchEngineService.search(toSearch));
            } while (!toSearch.equals(":quit"));
            console.exit();
        } catch (IllegalArgumentException | FileLoadingException e) {
            console.print(e.getMessage());
        }
    }
}
