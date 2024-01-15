package org.example.threadSafety.shareResource;

public class ThreadSafety {

    public static final void run() throws InterruptedException {
        final ThreadCounter threadCounter = new ThreadCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i ++){
                threadCounter.incrementCount();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i ++){
                threadCounter.incrementCount();
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("expect result is 2000 But, actual is " + threadCounter.getCount());
    }
}
