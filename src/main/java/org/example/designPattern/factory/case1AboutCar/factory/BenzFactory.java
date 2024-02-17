package org.example.designPattern.factory.case1AboutCar.factory;

import org.example.designPattern.factory.case1AboutCar.CarImpl.Car;
import org.example.designPattern.factory.case1AboutCar.CarImpl.Tesla;

public class BenzFactory extends CarFactory{
    @Override
    public Car createCar(String userInput, String newCarNumber){
        String carType = "benz";

        Car car = new Tesla(userInput, newCarNumber, carType);
        return car;
    }
}
