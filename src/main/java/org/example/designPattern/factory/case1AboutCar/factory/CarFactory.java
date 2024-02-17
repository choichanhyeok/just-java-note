package org.example.designPattern.factory.case1AboutCar.factory;

import org.example.designPattern.factory.case1AboutCar.CarImpl.Car;

public abstract class CarFactory {

    final public Car manufaturingCar(String userInput, String newCarNumber){
        Car car;
        this.prepareOthers();
        car = createCar(userInput, newCarNumber);
        this.washCar();

        return car;
    }

    private void prepareOthers(){
        System.out.println("prepare others");
    }

    private void washCar(){
        System.out.println("wash car");
    }

    public abstract Car createCar(String userInput, String newCarNumber);
}
