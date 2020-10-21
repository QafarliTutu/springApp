package com.testApp.springApp.exceptions;

public class EmployeeAlreadyExistEx extends InvalidStateException {

    private static final String MESSEGE = "Employee already exists with this email.";


    public EmployeeAlreadyExistEx(String message) {
        super(MESSEGE);
    }
}
