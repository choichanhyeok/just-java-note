package org.example.threadSafety.deadLock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockSolveTest2 {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    @DisplayName("DeadLockSolveTest2(1): 사전 할당을 이용한 데드락 해소")
    @Test
    public void test1() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> acquireLocksInOrder(lock1, lock2);
        Runnable task2 = () -> acquireLocksInOrder(lock2, lock1);

        executorService.submit(task1);
        executorService.submit(task2);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS); // 해당 코드 사용처 /example/multiThread 패키지에 예제 달아둠
    }

    private void acquireLocksInOrder(Object lock1, Object lock2) { // 그냥 락 객체 받아서 정렬해서 순서 보장한다는 내용이네, -> 사용하는 락 요소가 같을때만 사용 가능할 듯 ..

        Object first = (System.identityHashCode(lock1) >= System.identityHashCode(lock2))? lock1: lock2;
        Object second = (System.identityHashCode(lock1) < System.identityHashCode(lock2))? lock2: lock1;

        synchronized (first){
            System.out.println(Thread.currentThread().getName() + "acquired the first lock");
            synchronized (second){
                System.out.println(Thread.currentThread().getName() + "acquired the second lock");
            }
            System.out.println(Thread.currentThread().getName() + "release the second lock");
        }
        System.out.println(Thread.currentThread().getName() + "release the first lock");
    }
} // In witch situations would this approach
