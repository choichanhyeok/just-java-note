package org.example.threadSafety.ConcurrentCollection;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionBasicTest {

    @DisplayName("ConcurrentCollectionBasicTest(1): ")
    @Test
    protected void test1(){
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put(1, "Hyeok");
        concurrentHashMap.put(2, "gain");

    }



}
