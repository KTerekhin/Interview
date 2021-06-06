package ru.gb.task_1;

public class PingPong {
    private final Object mon = new Object();
    private volatile String currentWord = "Ping";

    public static void main(String[] args) {
        runPingPong();
    }

    public static void runPingPong() {
        PingPong waitNotifyObj = new PingPong();
        Thread thread1 = new Thread(waitNotifyObj::printPing);
        Thread thread2 = new Thread(waitNotifyObj::printB);
        thread1.start();
        thread2.start();
    }

    public void printPing() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!currentWord.equals("Ping")) {
                        mon.wait();
                    }
                    System.out.print("Ping ");
                    currentWord = "Pong";
                    mon.notify();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!currentWord.equals("Pong")) {
                        mon.wait();
                    }
                    System.out.print("Pong ");
                    currentWord = "Ping";
                    mon.notify();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
