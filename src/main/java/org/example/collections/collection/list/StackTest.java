package org.example.collections.collection.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {
    private Stack<Integer> numberStack = new Stack<>();

    public StackTest(){
        this.test1();
        this.test2();
        this.test3();
    }

    @BeforeEach
    public void clear(){
        numberStack = new Stack<Integer>();
    }


    @DisplayName("Stack Test(1): 삽입, 삭제 테스트")
    @Test
    protected void test1() {
        // given
        int[] expected = new int[]{15, 101, 3};
        numberStack.push(3);
        numberStack.push(101);
        numberStack.push(15);

        // when & then
        int[] actual = new int[]{numberStack.pop(), numberStack.pop(), numberStack.pop()};
        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("Stack Test(2): 빈 스택 peek() 테스트, EmptyStackException 발생")
    @Test
    protected void test2() {
        // given
        Stack<String> wordStack = new Stack<String>();

        // when & then
        Assertions.assertThrows(EmptyStackException.class, () -> {
            wordStack.peek();
        });
    }

    @DisplayName("Stack Test(3): 제네릭을 사용하지 않는 stack 테스트")
    @Test
    protected void test3() {
        // given
        Stack anyTypeStack = new Stack();
        Object[] expected = new Object[]{true, 26, "Hyeok"};
        Object[] actual = new Object[3];

        // when
        anyTypeStack.push("Hyeok");
        anyTypeStack.push(26);
        anyTypeStack.push(true);

        // then
        int i = 0;
        while (!anyTypeStack.isEmpty()){
            actual[i] = anyTypeStack.pop();
            i += 1;
        }
        Assertions.assertArrayEquals(expected, actual);
    }
}
