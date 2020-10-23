package com.testApp.springApp.exceptions;

public class EmployeeAlreadyExistEx extends InvalidStateException {

    private static final String MESSAGE = "Employee matching the given email already exists.";

    public EmployeeAlreadyExistEx() {
        super(MESSAGE);
    }
}
