package org.example.exception.uncheckedException.nullPointException;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NullPointExceptionTest {
    private Object emptyObject = null;


    public NullPointExceptionTest(){
        this.test1();
    }

    @DisplayName("NullPointExceptionTest(1): null인 객체 참조 테스트")
    @Test
    protected void test1(){
        Assertions.assertThrows(NullPointerException.class, () ->{
            emptyObject.toString();
        });
    }

    @DisplayName("NullPointExceptionTest(2): null인 객체 참조 테스트, Runtime Exception 으로 검사 하는 것도 허용 된다.")
    @Test
    protected void test2(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            emptyObject.toString();
        });
    }

    @DisplayName("NullPointExceptionTest(3): null인 객체 참조 테스트, 존재하지 않는 객체에 필드 접근")
    @Test
    protected void test3(){
        Assertions.assertThrows(NullPointerException.class, () -> {
           DummyDTO dummyDTO = null;
            int age = dummyDTO.getAge();
        });
    }


    class DummyDTO{
        int age;

        private int getAge(){
            return age;
        }
    }
}
