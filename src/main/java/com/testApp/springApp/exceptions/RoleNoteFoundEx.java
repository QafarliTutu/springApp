package com.testApp.springApp.exceptions;

public class RoleNoteFoundEx extends NotFoundException{
    private static final String MESSAGE = "No role matching the given id was found.";

    public RoleNoteFoundEx() {
        super(MESSAGE);
    }
}
