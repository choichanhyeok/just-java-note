package org.example.threadSafety.ConcurrentCollection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentCollectionTest {
    Map<Integer, Integer> unSupportSyncMap;

    @BeforeEach
    public void setup(){
        unSupportSyncMap = new HashMap();
    }

    @DisplayName("ConcurrentCollectionTest(1): 일반 HashMap을 사용하면 동시성 이슈 발생")
    @Test
    protected void test1(){
        // given
        final Thread t1 = new Thread(() -> { addItem(unSupportSyncMap); });
        final Thread t2 = new Thread(() -> { addItem(unSupportSyncMap); });

        // when
        processingTwoThread(t1, t2);

        // then
        int expectedCount = 2000;
        int actualCount = unSupportSyncMap.get(0);
        Assertions.assertNotEquals(expectedCount, actualCount);

    }

    @DisplayName("ConcurrentCollectionTest(2): synchorinized Method를 이용해도 해동 동시성 이슈 해결 불가")
    @Test
    protected void test2(){
        // given
        final Map<Integer, Integer> syncMap = Collections.synchronizedMap(unSupportSyncMap);
        final Thread t1 = new Thread(() -> { addItem(syncMap); });
        final Thread t2 = new Thread(() -> { addItem(syncMap); });

        // when
        processingTwoThread(t1, t2);

        // then
        int expectedCount = 2000;
        int actualCount = unSupportSyncMap.get(0);
        Assertions.assertNotEquals(expectedCount, actualCount);
    }

    @DisplayName("ConcurrentCollectionTest(3): ConcurrentHashMap을 이용해서 put 해도 동시성 문제 해결 불가")
    @Test
    protected void test3(){
        // given
        final ConcurrentMap<Integer, Integer> concurrentMap = new ConcurrentHashMap();
        final Thread t1 = new Thread(() -> { addItem(concurrentMap);});
        final Thread t2 = new Thread(() -> { addItem(concurrentMap);});

        // when
        processingTwoThread(t1, t2);

        // then
        int expectedCount = 2000;
        int actualCount = concurrentMap.get(0);
        Assertions.assertNotEquals(expectedCount, actualCount);
    }

    @DisplayName("ConcurrentCollectionTest(4): ConcurrentHashMap을 이용해서 compute를 이용시 해결 가능")
    @Test
    protected void test4(){
        // given
        final ConcurrentMap<Integer, Integer> concurrentMap = new ConcurrentHashMap();
        final Thread t1 = new Thread(() -> { addItemBycompute(concurrentMap);});
        final Thread t2 = new Thread(() -> { addItemBycompute(concurrentMap);});

        // when
        processingTwoThread(t1, t2);

        // then
        int expectedCount = 2000;
        int actualCount = concurrentMap.get(0);
        Assertions.assertEquals(expectedCount, actualCount);
    }

    private void addItem(final Map<Integer, Integer> map){
        for (int i = 0; i < 1000; i ++){
            if (map.containsKey(0)) {
                map.put(0, map.get(0) + 1);
            }else {
                map.put(0, 1);
            }
        }
    }

    private void addItemBycompute(final ConcurrentMap<Integer, Integer> concurrentMap) {
        for (int i = 0; i < 1000; i ++) {
            concurrentMap.compute(0, (key, value) -> (value == null) ? 1 : value + 1);
        }
    }

    private void processingTwoThread(final Thread t1, final Thread t2){
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
