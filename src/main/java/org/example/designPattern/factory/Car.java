package org.example.designPattern.factory;

public abstract class Car {
    private static String name;
    private static String carNumber;
    private static String type;

    public Car(final String name, final String carNumber, final String type){
        this.name = name;
        this.carNumber = carNumber;
        this.type = type;
    }

    public String showCarInfo(){
       return this.name + " " + this.carNumber;
    }
}
