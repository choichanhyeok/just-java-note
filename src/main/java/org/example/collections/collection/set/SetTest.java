package org.example.collections.collection.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public SetTest(){
        this.test1();
        this.test2();
        this.test3();
        this.test4();
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
        // given
        HashSet hashSet = new HashSet();

        // when
        hashSet.add("최찬혁");
        hashSet.add(2024);
        hashSet.add("네이버 입사");
        hashSet.add("네이버 입사");

        // then
        Assertions.assertEquals(3, hashSet.size());
    }


    @DisplayName("SetTest(3): linkedSet method test all in one")
    @Test
    protected void test3(){ // 링크드 리스트 기반이어서 입력 순서가 보장된다.
        // given
        String[] expected = new String[]{"hyeok", "naver", "boy"};
        String[] actual = new String[3];

        // when
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("hyeok");
        linkedHashSet.add("naver");
        linkedHashSet.add("boy");   // * 링크드 헤쉬 셋은 늦게 들어간게 먼저 나온다.

        // then
        int i = 0;
        for (String word: linkedHashSet){
           actual[i] = word;
           i ++;
        }

        Assertions.assertArrayEquals(expected, actual);
    }


    @DisplayName("SetTest(4): TreeSet method test all in one")
    @Test
    protected void test4(){
        // given
        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(8);
        treeSet.add(45);

        Integer[] expected = new Integer[]{3, 5, 8, 45};
        Integer[] actual = new Integer[4];

        // when
        int i = 0;
        for (Integer number: treeSet){
            actual[i] = number;
            i ++;
        }

        // then
        Assertions.assertArrayEquals(expected, actual); // 입력만 해도 알아서 정렬됨
    }
}
