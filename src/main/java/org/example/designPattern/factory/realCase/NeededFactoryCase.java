package org.example.designPattern.factory.realCase;

import org.example.designPattern.factory.Car;
import org.example.designPattern.factory.CarImpl.Benz;
import org.example.designPattern.factory.CarImpl.Kia;
import org.example.designPattern.factory.CarImpl.Tesla;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NeededFactoryCase {

    // TODO 1. 팩토리 사용에 필요한 문제 발생시켜보기
    @Test
    public void 팩토리_적용이_필요한_문제_상황을_발생시키다() throws Exception {
        // given
        Car actualCar = null;
        String userInput = "Tesla model Z";
        String newCarNumber = String.valueOf(Math.random());

        // when
        if (userInput.equals("Tesla model Z") || userInput.equals("Tesla model Y") || userInput.equals("Tesla model X"))
            actualCar = new Tesla(userInput, newCarNumber, "tesla");
        else if (userInput == "kia model a" || userInput == "kia model b")
            actualCar = new Kia(userInput, newCarNumber, "kia");
        else if (userInput == "benz model k")
            actualCar = new Benz(userInput, newCarNumber, "benz");
        else {
            throw new CarException("잘못된 모델명을 입력했습니다");
        }

        // then
        Car expectedCar = new Tesla(userInput, newCarNumber, "tesla");
        Assertions.assertTrue(CarManager.isSameCarNumber(actualCar, expectedCar));
    }

    private class CarException extends RuntimeException{
        private String errMessage;
        private static final String errCode = "CB_001";
        private CarException(final String errMessage){
            this.errMessage = errMessage;
        }
    }
}