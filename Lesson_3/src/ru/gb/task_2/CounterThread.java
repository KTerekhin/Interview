package ru.gb.task_2;

import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {
    private Counter counter;
    private ReentrantLock locker;

    public CounterThread(Counter counter, ReentrantLock locker) {
        this.counter = counter;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            for (int i = 0; i < 1000; i++) {
                counter.increaseCounter();
            }
        } finally {
            locker.unlock();
        }
    }
}
