package com.aretesoft.model;

/**
 * Created by Ayodeji.Agboola on 5/9/2017.
 */
public class InvalidEmailException extends Exception {
    private String errorCode;
    public InvalidEmailException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
