# Kata Search Engine

Implementation of a simple search engine, console based.

## Building and running

To run the build with test coverage:

    ./gradlew clean build jacocoTestReport
    
You will find the coverage report on _kata-mars-rover/build/jacoco/reports/coverage/html/index.html_

You can run the MarsRover class on your IDE or by console:

    ./gradlew fatJar
    java -jar build/libs/kata-mars-rover-all-1.0.jar

## Instructions

The exercise is to write a command line driven text search engine, usage being:

    java mainClassFile pathToDirectoryContainingTextFiles

This should read all the text files in the given directory, building an in memory representation of the files and their contents, and then give a command prompt at which interactive searches can be performed.

An example session might look like:
    
    $ java jar SimpleSearch.jar /foo/bar
    14 files read in directory /foo/bar
    search> to be or not to be
    filename1 : 100%
    filename2 : 95%
    search> cats
    no matches found
    search> :quit
    
The search should take the terms given on the command prompt and return a list of the top 10 (max) matching filenames in rank order, giving the rank score against each match.

Note: treat the above as an outline spec; you don’t need to exactly reproduce the above output. Don’t spend too much time on input handling, just assume sane input.

### Ranking
* The rank score must be 100% if a file contains all the terms
* It must be 0% if it contains none of the terms
* It should be between 0 and 100 if it contains only some of the terms but the exact ranking formula is up to you to choose and implement 

### Things to consider in your implementation
* What constitutes a word
* What constitutes two terms being equal (and matching)
* Data structure design: the in memory representation to search against
* Ranking score design: start with something basic then iterate as time allows
* Testability