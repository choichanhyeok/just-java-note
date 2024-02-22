package org.example.designPattern.factory.normalFactory;

import org.example.designPattern.factory.normalFactory.factory.SimpleFactory;
import org.example.designPattern.factory.normalFactory.object.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplyingFactoryPatternTest {

    @Test
    protected void Facotry_Pattern_없을때(){
        // when
        Phone newPhone = SimpleFactory.createPhone("SamsungPhone");

        // then
        Assertions.assertEquals("삼성폰", newPhone.checkPhoneName());

    }
}
