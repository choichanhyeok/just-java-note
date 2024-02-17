package org.example.designPattern.factory.case1AboutCar;

public class CarException extends RuntimeException{

    private String errMessage;
    private static final String errCode = "CB_001";

    public CarException(final String errMessage){
        this.errMessage = errMessage;
    }
}