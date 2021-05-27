package ru.gb.task_2;

public class Lorry extends Car implements Moveable, Stopable {
    @Override
    public void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void move() {
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop() {
        System.out.println("Lorry is stop");
    }

    public void start() {
        System.out.println("Lorry is starting");
    }
}
