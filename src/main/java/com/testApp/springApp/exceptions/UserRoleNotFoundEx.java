package com.testApp.springApp.exceptions;

public class UserRoleNotFoundEx extends NotFoundException {
    private static final String MESSAGE = "User has Role not found.";

    public UserRoleNotFoundEx() {
        super(MESSAGE);
    }
}
