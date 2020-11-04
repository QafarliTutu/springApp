package com.testApp.springApp.exceptions;

public class UserAlreadyHasRoleEx extends InvalidStateException{

    private static final String MESSAGE = "User already has Role matching the given name.";

    public UserAlreadyHasRoleEx() {
        super(MESSAGE);
    }
}
