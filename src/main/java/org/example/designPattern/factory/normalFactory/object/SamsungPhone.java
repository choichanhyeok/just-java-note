package org.example.designPattern.factory.normalFactory.object;

public class SamsungPhone implements Phone{

    @Override
    public void call() {
        System.out.println("삼성 폰 통화 연결 시도");
    }

    @Override
    public void sendMessage() {
        System.out.println("삼성 폰 메시지 전송 시도");
    }

    @Override
    public String checkPhoneName() {
        return "삼성폰";
    }

}
