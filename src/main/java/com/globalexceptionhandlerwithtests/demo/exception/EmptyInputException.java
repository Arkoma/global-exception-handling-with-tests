package com.globalexceptionhandlerwithtests.demo.exception;

import lombok.Data;

@Data
public class EmptyInputException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
    public EmptyInputException(String errorMessage) {
        this.errorMessage=errorMessage;
    }
}
