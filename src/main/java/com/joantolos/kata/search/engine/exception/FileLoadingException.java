package com.joantolos.kata.search.engine.exception;

public class FileLoadingException extends Throwable {

    public FileLoadingException() {
        super(ErrorMessage.FILE_LOADING);
    }
}
