package org.example.designPattern.factory;

public class CarManager {
    protected static boolean isSameCarNumber(Car targetCar, Car compareCar){
        return targetCar.showCarInfo().equals(compareCar.showCarInfo());
    }
}
