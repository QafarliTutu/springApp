package com.testApp.springApp.exceptions;

public class EducationNotFoundEx extends NotFoundException {

    private static final String MESSEGE = "No education matching the given id was found.";

    public EducationNotFoundEx() {
        super(MESSEGE);
    }
}
