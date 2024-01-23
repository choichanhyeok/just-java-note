package org.example.collections.collection.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public SetTest(){
        this.test1();
        this.test2();
    }


    @DisplayName("SetTest(1): hash set method test")
    @Test
    protected void test1(){
        // given
        Set<String> hashSet = new HashSet<String>();
        Object[] expected = new Object[]{"hyeok", "king"};

        // when
        hashSet.add("hyeok");
        hashSet.add("hyeok");
        hashSet.add("king");

        // then
        Object[] processResult = hashSet.toArray();
        Assertions.assertArrayEquals(expected, processResult);
        Assertions.assertEquals(false, hashSet.contains("gain"));
        Assertions.assertEquals(true, hashSet.contains("hyeok"));
        Assertions.assertEquals(2, hashSet.size());
        Assertions.assertEquals(false, hashSet.isEmpty());

        hashSet.clear();
        Assertions.assertEquals(0, hashSet.size());
        Assertions.assertEquals(true, hashSet.isEmpty());
    }

    @DisplayName("SetTest(2): hashset은 제네릭 없이도 사용 가능하다")
    @Test
    protected void test2(){
        HashSet hashSet = new HashSet();

        hashSet.add("최찬혁");
        hashSet.add(2024);
        hashSet.add("네이버 입사");
        hashSet.add("네이버 입사");


        Assertions.assertEquals(3, hashSet.size());
    } // hashset에 제네릭을 붙이지 않아도 캐스팅 과정에 문제는 없다. 왜냐면 애초에 개별 요소 조회가 없기 떄문에, 하지만 입력되는 데이터 관리 측면에서 복잡성이 증가할 수 있다.
}
