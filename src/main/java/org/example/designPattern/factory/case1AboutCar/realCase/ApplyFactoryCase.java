package org.example.designPattern.factory.case1AboutCar.realCase;

import org.example.designPattern.factory.case1AboutCar.CarImpl.Car;
import org.example.designPattern.factory.case1AboutCar.CarImpl.Tesla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyFactoryCase {
    // TODO 1. 팩토리 패턴을 사용해 복잡성 해소해보기
    @Test
    public void 팩토리_적용을_통한_문제_상황_해결() throws Exception {
        // given
        Car actualCar = null;
        String inputType = "tesla";
        String userInput = "Tesla model Z";
        String newCarNumber = String.valueOf(Math.random());

        // when
        actualCar = CarManager.callNewCar(inputType, userInput, newCarNumber);

        // then
        Car expectedCar = new Tesla(userInput, newCarNumber, "tesla");
        assertTrue(CarManager.isSameCarNumber(actualCar, expectedCar));
    }
}
