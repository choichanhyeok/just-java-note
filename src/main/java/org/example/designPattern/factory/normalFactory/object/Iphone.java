package org.example.designPattern.factory.normalFactory.object;

public class Iphone implements Phone{

    @Override
    public void call() {
        System.out.println("아이폰 통화 연결 시도");
    }

    @Override
    public void sendMessage() {
        System.out.println("아이폰 메시지 전송");
    }

    @Override
    public String checkPhoneName() {
        return "아이폰";
    }

}
