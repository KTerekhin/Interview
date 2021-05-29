package ru.gb.task_2;

import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    public static void main(String[] args) {
        runCounterLock();
    }

    public static void runCounterLock() {
        Counter counter = new Counter();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < 200; i++) {
            CounterThread ct1 = new CounterThread(counter, locker);
            ct1.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter:" + counter.getCounter());
    }
}
