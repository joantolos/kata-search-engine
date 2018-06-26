package com.joantolos.kata.search.engine.service

import spock.lang.Specification

class ArgumentParserSpec extends Specification {

    def 'Argument parser should parse proper arguments'(){
        ArgumentParser argumentParser = new ArgumentParser(["/folder/otherFolder"] as String[])

        expect:
        argumentParser.getFolder() == "/folder/otherFolder"
    }

    def 'Argument parser should rise Illegal Argument Exception when the argument is null'(){
        when:
        new ArgumentParser(null)

        then: 'an Illegal Argument Exception is thrown'
        thrown(IllegalArgumentException)
    }

    def 'Argument parser should rise Illegal Argument Exception when the argument is empty'(){
        when:
        new ArgumentParser([] as String[])

        then: 'an Illegal Argument Exception is thrown'
        thrown(IllegalArgumentException)
    }

    def 'Argument parser should rise Illegal Argument Exception when the first argument is empty'(){
        when:
        new ArgumentParser([""] as String[])

        then: 'an Illegal Argument Exception is thrown'
        thrown(IllegalArgumentException)
    }

}
