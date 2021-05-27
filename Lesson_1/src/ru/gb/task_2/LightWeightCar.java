package ru.gb.task_2;

public class LightWeightCar extends Car {

    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop() {
        System.out.println("LightWeightCar is stop");
    }

    public void start() {
        System.out.println("Lorry is starting");
    }
}
