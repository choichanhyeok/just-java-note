package org.example.error.stackOverflow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackOverFlowTest {

    public StackOverFlowTest(){
        this.test1();
        this.test2();
    }

    @DisplayName("StackOverFlowTest(1): 무한 재귀, Error을 이용한")
    @Test
    protected void test1(){
        Assertions.assertThrows(Error.class, () -> {
            dummyMethod();
        });
    }

    @DisplayName("StackOverFlowTest(2): 무한 재귀, StackOverFlow를 이용한")
    @Test
    protected void test2(){
        Assertions.assertThrows(StackOverflowError.class, () -> {
            dummyMethod();
        });
    }


    private void dummyMethod(){
        dummyMethod();
    }
}
