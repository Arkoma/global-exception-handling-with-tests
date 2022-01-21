package com.globalexceptionhandlerwithtests.demo.exception;

public class EmptyInputException extends RuntimeException{
    public EmptyInputException(String errorMessage) {
        super(errorMessage);
    }
}
