package com.joantolos.kata.search.engine.ui

import com.joantolos.kata.search.engine.domain.SearchResult
import spock.lang.Specification

class ConsoleSpec extends Specification {

    def 'User Interface should print prompt'(){
        expect:
        new Console().prompt()
    }

    def 'User Interface should print exit'(){
        expect:
        new Console().exit()
    }

    def 'User Interface should print random text'(){
        expect:
        new Console().print("Random text")
    }

    def 'User Interface should print search results'(){
        expect:
        new Console().printSearchResult(new SearchResult("Looking for words", 10))
    }
}
