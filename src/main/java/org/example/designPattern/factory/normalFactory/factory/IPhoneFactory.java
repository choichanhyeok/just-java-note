package org.example.designPattern.factory.normalFactory.factory;

import org.example.designPattern.factory.normalFactory.object.Iphone;
import org.example.designPattern.factory.normalFactory.object.Phone;

public class IPhoneFactory implements PhoneFactory{

    @Override
    public Phone createPhone() {
        return new Iphone();
    }
}
