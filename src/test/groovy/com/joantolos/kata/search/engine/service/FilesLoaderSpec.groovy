package com.joantolos.kata.search.engine.service

import spock.lang.Shared
import spock.lang.Specification

class FilesLoaderSpec extends Specification {

    @Shared String fakeDataPath
    @Shared LoaderService loaderService

    def setupSpec() {
        loaderService = new LoaderService(fakeDataPath)
        fakeDataPath = new File(this.getClass().getResource('/angularTutorialExtended.txt').toURI()).getAbsolutePath()
    }

    def 'Files loader should load files from given folder'(){

    }

}
