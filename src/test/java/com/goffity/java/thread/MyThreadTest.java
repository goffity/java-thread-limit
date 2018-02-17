package com.goffity.java.thread;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class MyThreadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void start() {

        for (int i = 0; i < 1000; i++) {
            MyThread myThread = new MyThread("Thread " + i);
            myThread.start();
        }
    }

    @Test
    public void testThreadLimit() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Future future = null;
        for (int i = 0; i < 1000; i++) {
            future = executorService.submit(new MyThread("Thread " + i));
        }

        for (; ; ) {
            if (future.isDone()) {
                System.out.println("future.isDone() :" + future.isDone());
                break;
            }
        }

        executorService.shutdown();
    }

    @Test
    public void testThreadCached() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future future = null;
        for (int i = 0; i < 1000; i++) {
            future = executorService.submit(new MyThread("Thread " + i));
        }

        for (; ; ) {
            if (future.isDone()) {
                System.out.println("future.isDone() :" + future.isDone());
                break;
            }
        }

        executorService.shutdown();
    }
}