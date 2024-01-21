package org.example.threadSafety.deadLock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class DeadLockTest {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();
    private static final Object lock4 = new Object();

    public DeadLockTest() throws ExecutionException, InterruptedException {
        this.test1();
        this.test2();
    }

    @DisplayName("DeadLockTest (1): 데드락 발생 테스트")
    @Test
    protected void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future1 = executorService.submit(new ThreadDemoFirstBadCase());
        Future<?> future2 = executorService.submit(new ThreadDemoSecondBadCase());

        Assertions.assertThrows(TimeoutException.class, () -> {
            future1.get(15, TimeUnit.SECONDS);
            future2.get(15, TimeUnit.SECONDS);
        });
    }

    @DisplayName("DeadLockTest (2): 데드락 발생 해결 테스트")
    @Test
    protected void test2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future3 = executorService.submit(new ThreadDemoFirstGoodCase());
        Future<?> future4 = executorService.submit(new ThreadDemoSecondGoodCase());

        future3.get();
        future4.get();
    }

    private static class ThreadDemoFirstBadCase extends Thread {
        public void run() {
            synchronized(lock1){
                System.out.println("Thread 1: Holding lock 1...");

                try { Thread.sleep(10000); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 1..");

                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class ThreadDemoSecondBadCase extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 2...");

                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class ThreadDemoFirstGoodCase extends Thread {
        public void run() {
            synchronized(lock3){
                System.out.println("Thread 1: Holding lock 3...");

                try { Thread.sleep(10000); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 3..");

                synchronized (lock4) {
                    System.out.println("Thread 1: Holding lock 3 & 4...");
                }
            }
        }
    }

    private static class ThreadDemoSecondGoodCase extends Thread {
        public void run() {
            synchronized (lock3) {
                System.out.println("Thread 3: Holding lock 3...");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {}
                System.out.println("Thread 3: Waiting for lock 3...");

                synchronized (lock4) {
                    System.out.println("Thread 3: Holding lock 3 & 4...");
                }
            }
        }
    }
}