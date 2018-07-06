package com.joantolos.kata.search.engine.service

import com.joantolos.kata.search.engine.ui.Console
import spock.lang.Shared
import spock.lang.Specification

class SearchEngineServiceTest extends Specification {

    @Shared SearchEngineService searchEngineService

    def setupSpec() {
        searchEngineService = new SearchEngineService(new LoaderService(new File(
                this.getClass()
                        .getResource('/angularTutorialExtended.txt')
                        .toURI())
                .getAbsolutePath()
                .replace('/angularTutorialExtended.txt',''), new Console()).load())
    }

    def 'Search engine should search'(){
        expect:
        searchEngineService.search('is that the')
    }
}
