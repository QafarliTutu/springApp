package com.testApp.springApp.exceptions;

public class RoleAlreadyExistEx extends InvalidStateException{
    private static final String MESSAGE = "Role matching the given name already exists.";

    public RoleAlreadyExistEx() {
        super(MESSAGE);
    }
}
