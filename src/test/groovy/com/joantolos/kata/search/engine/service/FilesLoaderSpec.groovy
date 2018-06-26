package com.joantolos.kata.search.engine.service

import com.joantolos.kata.search.engine.domain.AppFile
import spock.lang.Shared
import spock.lang.Specification

class FilesLoaderSpec extends Specification {

    @Shared LoaderService loaderService

    def setupSpec() {
        loaderService = new LoaderService(
                new File(
                        this.getClass()
                                .getResource('/angularTutorialExtended.txt')
                                .toURI())
                        .getAbsolutePath()
                        .replace('/angularTutorialExtended.txt',''))
    }

    def 'Files loader should load 13 files from the test resources folder'(){
        given:
        List<AppFile> appFiles = loaderService.load()

        expect:
        appFiles.size() == 13
    }

    def 'First three file names should be correct'(){
        given:
        List<AppFile> appFiles = loaderService.load()

        expect:
        appFiles.get(0).getName() == 'artificialIntelligence.txt'
        appFiles.get(1).getName() == 'tennisKata.txt'
        appFiles.get(2).getName() == 'readability.txt'
    }

    def '13 file content should be not null'(){
        given:
        List<AppFile> appFiles = loaderService.load()

        expect:
        appFiles.each{
            appFile -> appFile.content != null
        }
    }

}
