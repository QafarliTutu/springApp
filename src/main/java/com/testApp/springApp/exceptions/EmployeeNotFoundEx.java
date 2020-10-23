package com.testApp.springApp.exceptions;

public class EmployeeNotFoundEx extends NotFoundException {
    private static final String MESSAGE = "No employee matching the given id was found.";

    public EmployeeNotFoundEx() {
        super(MESSAGE);
    }


}
