package org.example.designPattern.factory.normalFactory;

import org.example.designPattern.factory.normalFactory.factory.SimpleFactory;
import org.example.designPattern.factory.normalFactory.object.Phone;
import org.junit.jupiter.api.Test;

public class ApplyingFactoryPatternTest {

    @Test
    protected void Facotry_Pattern_있을때(){
        // when
        Phone newPhone1 = SimpleFactory.createPhone("SamsungPhone");
        Phone newPhone2 = SimpleFactory.createPhone("IPHONE");
        Phone newPhone3 = SimpleFactory.createPhone("SamsungPhone");

    }
}
