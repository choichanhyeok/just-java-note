package org.example;

import org.example.exception.ExceptionTestRunner;

import java.io.IOException;

public class Main {
    public static void main(String[] hyeok) {
        // ThreadSafety.run();
        // DeadLockTest.run();

        new ExceptionTestRunner();
    }
}