package org.example.designPattern.factory.factory;

import org.example.designPattern.factory.Car;
import org.example.designPattern.factory.CarException;
import org.example.designPattern.factory.CarImpl.Tesla;

public class BenzFactory extends CarFactory{
    @Override
    public Car createCar(String userInput, String newCarNumber){
        String carType = "benz";

        Car car = new Tesla(userInput, newCarNumber, carType);
        return car;
    }
}
