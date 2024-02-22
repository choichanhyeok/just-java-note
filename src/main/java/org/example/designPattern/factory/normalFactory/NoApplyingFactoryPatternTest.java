package org.example.designPattern.factory.normalFactory;

import org.example.designPattern.factory.normalFactory.object.Iphone;
import org.example.designPattern.factory.normalFactory.object.SamsungPhone;
import org.junit.jupiter.api.Test;

public class NoApplyingFactoryPatternTest {

    @Test
    protected void Facotry_Pattern_없을때(){
        int testSize = 3;
        // when
        String[] inputTypes = new String[testSize];
        String[] outputNames = new String[testSize];

        for (int i = 0; i < testSize; i ++) {
            if (inputTypes[i] == "IPHONE") {
                outputNames[i] = new Iphone().checkPhoneName();
            } else if (inputTypes[i] == "SamsungPhone") {
                outputNames[i] = new SamsungPhone().checkPhoneName();
            } else {
                throw new RuntimeException("지원하지 않는 휴대폰 기종을 입력하셨습니다.");
            }
        }
    }

}
