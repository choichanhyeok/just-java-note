package org.example.exception.uncheckedException.ArithmeticException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArithmeticExceptionTest {

    @DisplayName("ArithmeticExceptionTest(1): 0으로 나누는 경우")
    @Test
    protected void test1(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
           int foo = 10/0;
        });
    }
}
