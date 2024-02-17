package org.example.designPattern.factory.case2AboutDao.fakeJDBC;

public class TestConnectionException extends RuntimeException{
    private String message;
    private String stackTrace;

    public TestConnectionException(String message, String stackTrace){
        this.message = message;
        this.stackTrace = stackTrace;
    }

    @Override
    public String getMessage(){
        return "message: " + message
                + "\n" + "stackTrace: " + stackTrace;
    }
}
