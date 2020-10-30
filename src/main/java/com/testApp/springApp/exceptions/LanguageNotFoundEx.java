package com.testApp.springApp.exceptions;

public class LanguageNotFoundEx extends NotFoundException{

    private static final String MESSAGE = "No language matching the given id was found.";

    public LanguageNotFoundEx() {
        super(MESSAGE);
    }
}
