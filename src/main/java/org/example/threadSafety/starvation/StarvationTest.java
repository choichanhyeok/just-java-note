package org.example.threadSafety.starvation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StarvationTest {
    private Object sharedResource = new Object();

    @DisplayName("StarvationTest(1): ")
    @Test
    private void test1(){
        // TODO 1. StarVation Test는 일단 보류
    }

    private class WorkThread extends Thread {
        public WorkThread(int priority) {
            setPriority(priority);
        }

        @Override
        public void run(){
            while (true) {
                synchronized (sharedResource){
                    System.out.println(Thread.currentThread().getName() + " is working");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
