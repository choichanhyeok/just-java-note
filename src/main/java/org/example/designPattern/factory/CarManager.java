package org.example.designPattern.factory;

import org.example.designPattern.factory.factory.BenzFactory;
import org.example.designPattern.factory.factory.KiaFactory;
import org.example.designPattern.factory.factory.TeslaFactory;

public class CarManager {
    protected static boolean isSameCarNumber(Car targetCar, Car compareCar){
        return targetCar.showCarInfo().equals(compareCar.showCarInfo());
    }

    protected static Car callNewCar(String inputType, String userInput, String newCarNumber){
        if (inputType == "tesla")
            return new TeslaFactory().manufaturingCar(userInput, newCarNumber);
        else if (inputType == "kia")
            return new KiaFactory().manufaturingCar(userInput, newCarNumber);
        else
            return new BenzFactory().manufaturingCar(userInput, newCarNumber);
    }
}
