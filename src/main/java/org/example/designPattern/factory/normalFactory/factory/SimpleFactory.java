package org.example.designPattern.factory.normalFactory.factory;

import org.example.designPattern.factory.normalFactory.object.Iphone;
import org.example.designPattern.factory.normalFactory.object.Phone;
import org.example.designPattern.factory.normalFactory.object.SamsungPhone;

public class SimpleFactory {
    public static Phone createPhone(final String type){

        if (type == "IPHONE"){
            return new Iphone();
        } else if (type == "SamsungPhone"){
            return new SamsungPhone();
        } else {
            throw new RuntimeException("지원하지 않는 휴대폰 기종을 입력하셨습니다.");
        }
    }

}
