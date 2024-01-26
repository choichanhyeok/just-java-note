package org.example.multiThread.ExecutorShutdownAndAwait;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownAndAwaitTest {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @DisplayName("shutdown and await test of ExecutorService")
    @Test
    protected void test1() throws InterruptedException {
        for (int i = 0; i < 20; i ++){
            handleRequest(i);
        }
        shutdown();
    }

    private void handleRequest(int requestId){
        executorService.submit(() -> {
            System.out.println("처리 시작: 요청 ID " + requestId + " - " + Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("처리 중단: 요청 ID " + requestId + " - " + Thread.currentThread().getName());
            }
        });
    }

    private void shutdown() throws InterruptedException {
        // TODO 1. 작업 수락 일단 막아놓고
        executorService.shutdown();

        // TODO 2. 60초 지나면 강제 종료
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            executorService.shutdown();
            System.out.println("@ 강제 종료 ");
        }
    }
}
