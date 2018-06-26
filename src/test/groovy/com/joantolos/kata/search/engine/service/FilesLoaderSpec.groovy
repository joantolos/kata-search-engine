package com.joantolos.kata.search.engine.service

import com.joantolos.kata.search.engine.domain.AppFile
import spock.lang.Shared
import spock.lang.Specification

class FilesLoaderSpec extends Specification {

    @Shared LoaderService loaderService

    def setupSpec() {
        loaderService = new LoaderService(new File(this.getClass().getResource('/angularTutorialExtended.txt').toURI()).getAbsolutePath())
    }

    def 'Files loader should load files from a given folder'(){
        given:
        List<AppFile> appFiles = loaderService.load()

        expect:
        appFiles.size() == 0
    }

}
