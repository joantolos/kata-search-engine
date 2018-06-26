package com.joantolos.kata.search.engine.service;

import com.joantolos.kata.search.engine.exception.ErrorMessage;
import org.apache.commons.lang3.StringUtils;

public class ArgumentParser {

    private String folder;

    public ArgumentParser(String[] args) throws IllegalArgumentException {
        if(args!=null && args.length > 0 && !StringUtils.isBlank(args[0])){
            this.folder = args[0];
        } else {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_ARGUMENTS);
        }
    }

    public String getFolder() {
        return folder;
    }
}
