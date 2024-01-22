package org.example.collections.collection.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public ListTest(){
        this.test1();
        this.test2();
        this.test3();
        this.test4();
        this.test5();
        this.test6();
        this.test7();
        this.test8();
        this.test9();
    }

    @DisplayName("List 학습용 테스트(1): String Type, ArrayList.add()")
    @Test
    protected void test1(){
        // given
        List<String> wordList = new ArrayList();

        //when
        wordList.add("hi");
        wordList.add("hyeok");

        // then
        Assertions.assertEquals("hi", wordList.get(0));
        Assertions.assertEquals("hyeok", wordList.get(1));
    }


    @DisplayName("List 학습용 테스트(2): Integer Type, ArrayList.add()")
    @Test
    protected void test2(){
        // given
        List<Integer> numberList = new ArrayList();

        // when
        numberList.add(1);
        numberList.add(2);

        // then
        Assertions.assertEquals(1, numberList.get(0));
        Assertions.assertEquals(2, numberList.get(1));
    }


    @DisplayName("List 학습용 테스트(3): Any Type, ArrayList.add()")
    @Test
    protected void test3(){
        /**
         *  ** List도 결국 Generic과 같이 사용하는 경우에만 타입 안전성을 보장한다. **
         */
        // given
        List anyList = new ArrayList();

        // when
        anyList.add(1);
        anyList.add("hi");
        anyList.add(3.14);

        // then
        Assertions.assertEquals(1, anyList.get(0));
        Assertions.assertEquals("hi", anyList.get(1));
        Assertions.assertEquals(3.14, anyList.get(2));
    }

    @DisplayName("List 학습용 테스트(4): Any Type, ArrayList.add()")
    @Test
    protected void test4(){
        // given
        List anyList = new ArrayList();

        // when
        anyList.add(3);
        anyList.add(4L);
        anyList.add("hi");

        // then
        Assertions.assertEquals(3, anyList.get(0));
        Assertions.assertEquals(4L, anyList.get(1));
        Assertions.assertEquals("hi", anyList.get(2));
    }

    @DisplayName("List 학습용 테스트(5): Any Type, LinkedList.add()")
    @Test
    protected void test5(){
        // given
        List<String > linkedList = new LinkedList<>();

        // when
        linkedList.add("hi");
        linkedList.add("hyeok");

        // then
        Assertions.assertEquals("hi", linkedList.get(0));
        Assertions.assertEquals("hyeok", linkedList.get(1));
    }

    @DisplayName("List 학습용 테스트(6): Any Type, LinkedList.add()")
    @Test
    protected void test6(){
        // given
        List linkedList = new LinkedList();

        // when
        linkedList.add("Foo");
        linkedList.add(29);

        // then
        Assertions.assertEquals("Foo", linkedList.get(0));
        Assertions.assertEquals(29, linkedList.get(1));
    }

    @DisplayName("List 학습용 테스트(7): Any Type, LinkedList.delete()")
    @Test
    protected void test7(){
        // given
        List linkedList = new LinkedList();

        linkedList.add("Foo");
        linkedList.add(29);

        // when
        linkedList.remove(1);

        // then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(1);
        });
    }

    @DisplayName("List 학습용 테스트(8): Any Type, LinkedList.delete(): 0번 인덱스를 지웠을 때 1번 인덱스가 0번 인덱스로 대체된다.")
    @Test
    protected void test8(){
        // given
        List linkedList = new LinkedList();

        linkedList.add("Foo");
        linkedList.add(29);

        // when
        linkedList.remove(0);

        // then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(1);
        });
    }

    @DisplayName("List 학습용 테스트(9): String Type, ArrayList.delete(): 0번 인덱스를 지웠을 때 1번 인덱스가 0번 인덱스를 대체한다.")
    @Test
    protected void test9(){
        //given
        List<String> arrayList = new ArrayList();

        arrayList.add("Foo");
        arrayList.add("Bar");

        //when
        arrayList.remove(0);

        //then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
           arrayList.get(1);
        });
    }
}
