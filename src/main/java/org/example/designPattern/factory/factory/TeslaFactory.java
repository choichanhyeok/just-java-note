package org.example.designPattern.factory.factory;

import org.example.designPattern.factory.Car;
import org.example.designPattern.factory.CarImpl.Tesla;

public class TeslaFactory extends CarFactory{

    @Override
    public Car createCar(String userInput, String newCarNumber){
        Car car = null;
        String carType = "tesla";

        if (userInput.equalsIgnoreCase("tesla model Z"))
            car = new Tesla(userInput, newCarNumber, carType);
        else if (userInput.equalsIgnoreCase("tesla model Y"))
            car = new Tesla(userInput, newCarNumber, carType);
        else if (userInput.equalsIgnoreCase("tesla model X"))
            car = new Tesla(userInput, newCarNumber, carType);
        else {
            throw new CarException("잘못된 모델명을 입력했습니다");
        }

        return car;
    }
}
