package org.example.generic.betterTypeSafety;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TypeSafetyOnGenriceTest {

    public TypeSafetyOnGenriceTest(){
        this.test1();
    }

    @Test
    @DisplayName("how to save typeSafety in generic Test(1): String List에 int 형 값 입력 불가")
    protected void test1(){
        List<Object> words = new ArrayList<>();
        words.add("Hello");
        words.add("Hyeok");

        words.add(1);

        Assertions.assertThrows(ClassCastException.class, () ->{
            for (Object obj : words) {
                String word = (String)obj;   // exception 발생

                System.out.println(word.toUpperCase());
            }
        });
    }

    @DisplayName("how to save typeSafety in generic Test(2): 제네릭 사용하면 컴파일 시점에서 타입 에러를 잡아낼 수 있다.")
    private void test2(){
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Hyeok");

        // words.add(1); # 여기서 에러 발생
    }
}



