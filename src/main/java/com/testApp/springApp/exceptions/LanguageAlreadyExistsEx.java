package com.testApp.springApp.exceptions;

public class LanguageAlreadyExistsEx extends InvalidStateException {
    private static final String MESSAGE = "Language matching the given name already exists.";

    public LanguageAlreadyExistsEx() {
        super(MESSAGE);
    }
}
