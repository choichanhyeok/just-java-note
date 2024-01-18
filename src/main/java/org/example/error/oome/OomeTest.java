package org.example.error.oome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OomeTest {
    List dummyList = new ArrayList<>();

    public OomeTest(){
        this.test2();
    }

    @DisplayName("OutOfMemoryErrorTest(1): 무한 배열 생성 # Error로도 예외 얻지 못함, 테스트 불가능")
    @Test
    protected void test1(){
        Assertions.assertThrows(Error.class, () -> {
            while(true){
                dummyList.add(new byte[100000]);
            }
        });
    }

    @DisplayName("OutOfMemoryErrorTest(2): 직접 찍어보는 건 가능")
    @Test
    protected void test2(){
        Assertions.assertThrows(Error.class, () -> {
            throw new OutOfMemoryError();
        });
    }


}
