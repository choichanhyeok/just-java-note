package org.example.designPattern.factory.normalFactory;

import org.example.designPattern.factory.normalFactory.factory.IPhoneFactory;
import org.example.designPattern.factory.normalFactory.factory.SamsungPhoneFactory;
import org.example.designPattern.factory.normalFactory.factory.SimpleFactory;
import org.example.designPattern.factory.normalFactory.object.Phone;
import org.junit.jupiter.api.Test;










public class ApplyingFactoryPatternTest {

    @Test
    protected void Factory_Pattern_있을때(){
        // when
        Phone newPhone1 = SimpleFactory.createPhone("SamsungPhone");
        Phone newPhone2 = SimpleFactory.createPhone("IPHONE");
        Phone newPhone3 = SimpleFactory.createPhone("SamsungPhone");

    }

    @Test
    protected void Factory_Method_패턴_사용했을때(){
        // when
        Phone newPhone1 = new SamsungPhoneFactory().createPhone();
        Phone newPhone2 = new IPhoneFactory().createPhone();
        Phone newPhone3 = new SamsungPhoneFactory().createPhone();
    }
}
