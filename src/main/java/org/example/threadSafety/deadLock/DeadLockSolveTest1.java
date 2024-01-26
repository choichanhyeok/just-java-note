package org.example.threadSafety.deadLock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class DeadLockSolveTest1 {
    private Object firstLock = new Object();
    private Object secondLock = new Object();

    @DisplayName("DeadLockSolveTest(1): 데드락 발생")
    @Test
    public void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future1 = executorService.submit(new Test1FirstThread());
        Future<?> future2 = executorService.submit(new Test1SecondThread());

        Assertions.assertThrows(TimeoutException.class, () -> {
           future1.get(15, TimeUnit.SECONDS);
           future2.get(15, TimeUnit.SECONDS);
        });
    }

    @DisplayName("DeadLockSolveTest(2): 순차 할당을 이용한 데드락 해결")
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future1 = executorService.submit(new Test2FirstThread());
        Future<?> future2 = executorService.submit(new Test2SecondThread());

        future1.get();
        future2.get();
    }



    private class Test1FirstThread extends Thread{
        // TODO 1. first lock을 점유
        public void run(){
            synchronized (firstLock) {
                System.out.println("thread(1) get firstlock");

                try { // TODO 2. 0.1 초간 대기
                    Thread.sleep(100);
                    System.out.println("thread(1) wait ...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // TODO 2. second lock 점유 시도
                synchronized (secondLock) {
                    System.out.println("thread(1) try to get a second lock");
                }
            }
        }
    }

    private class Test1SecondThread extends Thread{
        public void run() {
            // TODO 1. second lock을 점유
            synchronized (secondLock) {
                System.out.println("thread(2) get secondlock");

                try { // TODO 2. 0.1초간 대기
                    System.out.println("thread(2) wait ..");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // TODO 3. second lock 점유 시도
                synchronized (firstLock) {
                    System.out.println("thread(2) try to get a second lock");
                }
            }
        }
    }

    private class Test2FirstThread extends Thread {
        public void run(){
            // TODO 1. 첫번째 락을 획득한다
            synchronized (firstLock){
                System.out.println("thread(1) get a lock 1");
                try { // TODO 2. 0.1초간 대기
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("wait ...");
                    throw new RuntimeException(e);
                }

                // TODO 3. 두번째 락을 획득한다.
                synchronized (secondLock){
                    System.out.println("try to get a second lock");
                }

                System.out.println("thread end ..");
            }
        }
    }

    private class Test2SecondThread extends Thread {
        public void run(){
            // TODO 1. 첫번째 락을 획득한다
            synchronized (firstLock){
                try { // TODO 2. 0.1초간 대기
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // TODO 3. 두번째 락을 획득한다.
                synchronized (secondLock){
                    System.out.println("try to get a second lock");
                }
            }

            System.out.println("thread end ..");
        }
    }
}
