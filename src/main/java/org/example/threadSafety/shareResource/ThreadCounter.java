package org.example.threadSafety.shareResource;

public class ThreadCounter {
    private int count;

    public int getCount() {
        return this.count;
    }

    public void incrementCount(){
        this.count ++;
    }
}
