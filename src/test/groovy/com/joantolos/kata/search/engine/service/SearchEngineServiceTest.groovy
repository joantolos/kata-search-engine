package com.joantolos.kata.search.engine.service

import com.joantolos.kata.search.engine.ui.Console
import spock.lang.Shared
import spock.lang.Specification

class SearchEngineServiceTest extends Specification {

    @Shared SearchEngineService searchEngineService

    def setupSpec() {
        String path = new File(
                this.getClass()
                        .getResource('/angularTutorialExtended.txt')
                        .toURI())
                .getAbsolutePath()
                .replace('/angularTutorialExtended.txt','');
        searchEngineService = new SearchEngineService(new LoaderService(path, new Console()).load())
    }

    def 'Search engine should search'(){
        expect:
        searchEngineService.search('lili word')
    }
}
