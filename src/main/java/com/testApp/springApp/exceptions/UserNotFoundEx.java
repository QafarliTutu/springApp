package com.testApp.springApp.exceptions;

public class UserNotFoundEx extends NotFoundException{

    private static final String MESSAGE = "No user matching the given id was found.";

    public UserNotFoundEx() {
        super(MESSAGE);
    }
}
