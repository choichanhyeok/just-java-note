package org.example.designPattern.factory.normalFactory.factory;

import org.example.designPattern.factory.normalFactory.object.Phone;
import org.example.designPattern.factory.normalFactory.object.SamsungPhone;

public class SamsungPhoneFactory implements PhoneFactory{

    @Override
    public Phone createPhone() {
        return new SamsungPhone();
    }
}
