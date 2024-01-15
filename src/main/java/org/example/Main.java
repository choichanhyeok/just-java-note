package org.example;

import org.example.threadSafety.shareResource.ThreadSafety;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafety.run();
    }
}