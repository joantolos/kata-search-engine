package com.joantolos.kata.search.engine;

import com.joantolos.kata.search.engine.service.ArgumentParser;
import com.joantolos.kata.search.engine.service.LoaderService;
import com.joantolos.kata.search.engine.service.SearchEngineService;
import com.joantolos.kata.search.engine.ui.Console;

import java.util.Scanner;

public class SearchEngineApp {

    public static void main(String[] args) {
        Console console = new Console();

        try {
            String path = new ArgumentParser(args).getFolder();
            SearchEngineService searchEngineService =
                    new SearchEngineService(
                            new LoaderService(path, console)
                                    .load());

            console.prompt(path);
            Scanner keyboard = new Scanner(System.in);
            String toSearch;
            do {
                console.print("\nsearch > ");
                toSearch = keyboard.nextLine();
                console.printSearchResult(searchEngineService.search(toSearch));
                console.nextSearch(path);
            } while (!toSearch.equals(":quit"));
            console.exit();
        } catch (IllegalArgumentException e) {
            console.print(e.getMessage());
        }
    }
}
