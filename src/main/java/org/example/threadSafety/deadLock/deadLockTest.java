package org.example.threadSafety.deadLock;

public class deadLockTest {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void run(){

    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized(lock1){
                System.out.println("Thread 1: Holding lock 1...");

                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 1...");

            }
        }
    }


    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (lock1){
                System.out.println("Thread 2: Holding lock 1...");

                try {Thread.sleep(10);}
                catch (InterruptedException e) {}
                System.out.println("Thread 2: Wating for lock 1...");

            }
        }
    }
}