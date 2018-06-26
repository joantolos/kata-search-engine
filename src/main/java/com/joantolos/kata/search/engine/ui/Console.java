package com.joantolos.kata.search.engine.ui;

import com.joantolos.kata.search.engine.domain.SearchResult;

public class Console {

    public Boolean prompt(String filesPath){
        System.out.println("                     _   ");
        System.out.println(" ___ ___ ___ ___ ___| |_ ");
        System.out.println("|_ -| -_| .'|  _|  _|   |");
        System.out.println("|___|___|__,|_| |___|_|_|");
        System.out.println("             _           ");
        System.out.println(" ___ ___ ___|_|___ ___   ");
        System.out.println("| -_|   | . | |   | -_|  ");
        System.out.println("|___|_|_|_  |_|_|_|___|  ");
        System.out.println("        |___|            " + "\n");
        System.out.println("Ready for searching on the folder: \n" + filesPath);
        return true;
    }

    public Boolean print(String toPrint){
        System.out.println(toPrint);
        return true;
    }

    public Boolean exit() {
        System.out.print("\nbye!\n\n");
        return true;
    }

    public Boolean printSearchResult(SearchResult search) {
        System.out.println(search.getTerm());
        return true;
    }
}
