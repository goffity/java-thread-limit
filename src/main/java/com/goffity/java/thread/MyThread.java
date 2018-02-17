package com.goffity.java.thread;

public class MyThread implements Runnable {
    private Thread thread;
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
