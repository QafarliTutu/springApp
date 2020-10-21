package com.testApp.springApp.exceptions;

public class NotFoundException  extends RuntimeException{
    public NotFoundException(String messege) {
        super(messege);
    }
}
