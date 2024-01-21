package org.example.threadSafety.deadLock;

import java.util.concurrent.ExecutionException;

public class DeadLockTestRunner {
public DeadLockTestRunner() throws ExecutionException, InterruptedException {
        new DeadLockTest();
    }
}
