package org.example.threadSafety.synchronizedMethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SynchronizedMethodTest {
    List<Integer> unSupportSyncList; // 이걸 왜 전역으로 설정하면 -> 문제 생기는가? -> 애초에 문제 생기는지 확인해보기
    Map<Integer, Integer> unsyncMap;

    @BeforeEach
    void setup(){
        unSupportSyncList = new ArrayList<>();
        unsyncMap = new HashMap<>();
    }

    @DisplayName("SynchronizedMethodTest(1): 동시성 문제가 발생하는 ArrayList를 직접 사용하는 방식")
    @Test
    protected void test1(){
        // given
        Thread t1 = new Thread(() -> { addItem(unSupportSyncList); });
        Thread t2 = new Thread(() -> { addItem(unSupportSyncList); });

        // when
        processingTwoThread(t1, t2);

        // then
        int expectCount = 2000;
        int actualCount = unSupportSyncList.size();
        assertNotEquals(expectCount, actualCount);
    }

    @DisplayName("SynchronizedMethodTest(2): 동시성 문제가 발생하는 ArrayList를 synchronizedMethod로 묶어 해소")
    @Test
    protected void test2(){
        // given
        List<Integer> supportSyncList = Collections.synchronizedList(unSupportSyncList);
        Thread t1 = new Thread(() -> { addItem(supportSyncList); });
        Thread t2 = new Thread(() -> { addItem(supportSyncList); });

        // when
        processingTwoThread(t1, t2);

        // then
        int expectCount = 2000;
        int actualCount = supportSyncList.size();
        assertEquals(expectCount, actualCount);
    }


    @DisplayName("SynchronizedMethodTest(3): Map에 대한 synchronizedMethod 처리, 그럼에도 동시성 문제 발생")
    @Test
    protected void test3() {
        // given
        Map<Integer, Integer> syncMap = Collections.synchronizedMap(unsyncMap);

        Thread t1 = new Thread(() -> { addItem(syncMap); });
        Thread t2 = new Thread(() -> { addItem(syncMap); });

        // when
        processingTwoThread(t1, t2);

        // then
        int expected = 1000;
        int actual = syncMap.get(0);
        Assertions.assertNotEquals(expected, actual);

        // TODO. 동시성 이슈 발생 이유 찾아보기
        /**
         * Collections.synchronized(Method) 형태의 작업은 get(), put(), containsKey() 같은 개별 메서드 수준에만 적용되는 개념이기 때문에
         * 여러 스레드에서 해당 메서드에 대한 호출이 일어날 때 .. 왜 문제가 생기지? 아 .. 해당 객체에 대한 락이 아니라 메서드에 대한 락이기 때문이지 !
         * 일단 실제 Collections.synchronized 코드 훑어보면서 원리 이해해보자.
         */

        // TODO. 결론적으로 이 문제를 해결하려면 ConcurrentCollection을 이용해야한다.
    }

    @DisplayName("SynchronizedMethodTest(4): 일반 HashMap이 발생시키는 동시성 문제")
    @Test
    protected void test4() {
        // given
        Thread t1 = new Thread(() -> { addItem(unsyncMap); });
        Thread t2 = new Thread(() -> { addItem(unsyncMap); });

        // when
        processingTwoThread(t1, t2);

        // then
        int expected = 1000;
        int actual = unsyncMap.get(0);
        Assertions.assertNotEquals(expected, actual);
    }

    private void addItem(List<Integer> numberList){
        for (int i = 0; i < 1000; i ++){
            numberList.add(i);
        }
    }

    private void addItem(Map<Integer, Integer> numberMap){
        for (int i = 0; i < 1000; i ++){
            if (numberMap.containsKey(0)) {
                numberMap.put(0, numberMap.get(0) + 1);
            }else {
                numberMap.put(0, 1);
            }
        }
    }

    private void processingTwoThread(Thread t1, Thread t2){
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
