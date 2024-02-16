package org.example.StringBasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EachStringCompareTest {

    @DisplayName("EachStringCompareTest(1): 런타임에서 조합된 String은 내용이 같아도 같은 문자열 상수 풀에 저장되지 않아서 ==으로 비교할 수 없다")
    @Test
    void test1(){
        // given
        String userInput = " 똥";
        String baseSentence = "최찬혁" + userInput;
        String targetSentence = "최찬혁" + userInput;

        // when
        boolean actualResult = (baseSentence == targetSentence);

        // then
        Assertions.assertFalse(actualResult);
    }

    @DisplayName("EachStringCompareTest(2): 하지만 +를 한다고 런타임에서 도는 게 아니라 리터럴 스트링에 변수를 더하는 형태로 가야 런타임에 동작하는 것이다.")
    @Test
    void test2(){
        // givne
        String baseSentence = "최찬혁" + " 똥";
        String targetSentence = "최찬혁" + " 똥";

        // when
        boolean actualResult = (baseSentence == targetSentence);

        // then
        Assertions.assertTrue(actualResult);

    }

    @DisplayName("EachStringCompareTest(3): 런타임 과정에서 생성되는 문자열들은 eqauls를 통해 비교해야한다.")
    @Test
    void test3(){
        // given
        String userInput = " 똥";
        String baseSentence = "최찬혁" + userInput;
        String targetSentence = "최찬혁" + userInput;

        // when
        boolean actualResult = (baseSentence.equals(targetSentence));

        // then
        Assertions.assertTrue(actualResult);
    }

}
