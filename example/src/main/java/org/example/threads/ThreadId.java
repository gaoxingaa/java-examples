package org.example.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId. getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId. get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread:" + threadId.get());

            Thread thread = new Thread(){
                @Override public void run() {
                    System.out.println("loop thread:" + threadId.get());
                }
            };
            thread.start();
        }

    }
}

