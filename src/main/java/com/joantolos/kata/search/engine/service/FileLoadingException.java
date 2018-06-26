package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.exception.ErrorMessage;

public class FileLoadingException extends Throwable {

    public FileLoadingException() {
        super(ErrorMessage.FILE_LOADING);
    }
}
