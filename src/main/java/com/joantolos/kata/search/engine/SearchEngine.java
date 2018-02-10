package com.joantolos.kata.search.engine;

import java.io.File;
import java.util.Scanner;

public class SearchEngine {
    public static void main(String[] args) {
        if (args. length == 0 ) {
            throw new IllegalArgumentException( "No directory given to index." );
        }
        final File indexableDirectory = new File(args[0]);
        // TODO: Index all files in indexableDirectory
        Scanner keyboard = new Scanner(System.in);
        String line;
        do {
            System.out.print("search > " );
            line = keyboard.nextLine();
        } while (!line.equals(":quit"));
    }
}
