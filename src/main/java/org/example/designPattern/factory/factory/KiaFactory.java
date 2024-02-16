package org.example.designPattern.factory.factory;

import org.example.designPattern.factory.Car;
import org.example.designPattern.factory.CarImpl.Tesla;

public class KiaFactory extends CarFactory{
    @Override
    public Car createCar(String userInput, String newCarNumber){
        Car car = null;
        String carType = "kia";

        if (userInput.equalsIgnoreCase("kia model Z"))
            car = new Tesla(userInput, newCarNumber, carType);
        else if (userInput.equalsIgnoreCase("kia model Y"))
            car = new Tesla(userInput, newCarNumber, carType);
        else if (userInput.equalsIgnoreCase("kia model X"))
            car = new Tesla(userInput, newCarNumber, carType);
        else {
            throw new CarException("잘못된 모델명을 입력했습니다");
        }

        return car;
    }
}