package com.joantolos.kata.search.engine.ui

import com.joantolos.kata.search.engine.service.LoaderService
import com.joantolos.kata.search.engine.service.SearchEngineService
import spock.lang.Shared
import spock.lang.Specification

class ConsoleSpec extends Specification {

    @Shared SearchEngineService searchEngineService

    def setupSpec() {
        searchEngineService = new SearchEngineService(new LoaderService(new File(
                this.getClass()
                        .getResource('/angularTutorialExtended.txt')
                        .toURI())
                .getAbsolutePath()
                .replace('/angularTutorialExtended.txt',''), new Console()).load())
    }

    def 'User Interface should print prompt'(){
        expect:
        new Console().prompt()
    }

    def 'User Interface should print the next search'(){
        expect:
        new Console().nextSearch()
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
        new Console().printSearchResult(searchEngineService.search('is that the'))
    }
}
