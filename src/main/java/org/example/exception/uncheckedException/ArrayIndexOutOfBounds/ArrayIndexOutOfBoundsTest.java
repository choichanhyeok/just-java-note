package org.example.exception.uncheckedException.ArrayIndexOutOfBounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayIndexOutOfBoundsTest {
    int[] dummyNumbers = {1, 2, 3};


    public ArrayIndexOutOfBoundsTest(){
        this.test1();
        this.test2();
        this.test3();
        this.test4();
        this.test5();
    }

    @DisplayName("ArrayIndexOutOfBoundsTest(1): 존재하지 않은 인덱스 접근")
    @Test
    protected void test1(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dummyNumbers[3] = 3;
        });
    }

    @DisplayName("ArrayIndexOutOfBoundsTest(2): 음수 인덱스 접근")
    @Test
    protected void test2(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dummyNumbers[-1] = 2;
        });
    }

    @DisplayName("ArrayIndexOutOfBoundsTest(3): 상위 클래스인 RuntimeException으로도 체크 가능")
    @Test
    protected void test3(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            dummyNumbers[-1] = 2;
        });
    }

    @DisplayName("ArrayIndexOutOfBoundsTest(4): 상위 클래스인 ThrowAble 으로도 체크 가능")
    @Test
    protected void test4(){
        Assertions.assertThrows(Throwable.class, () -> {
            dummyNumbers[-1] = 2;
        });
    }

    @DisplayName("ArrayIndexOutOfBoundsTest(5): 상위 클래스인 Object로도 체크 가능")
    @Test
    protected void test5(){
        Assertions.assertThrows(Throwable.class, () -> {
            dummyNumbers[-1] = 2;
        });
    }
}
