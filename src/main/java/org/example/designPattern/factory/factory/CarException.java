package org.example.designPattern.factory.factory;

public class CarException extends RuntimeException{

    private String errMessage;
    private static final String errCode = "CB_001";

    protected CarException(final String errMessage){
        this.errMessage = errMessage;
    }
}