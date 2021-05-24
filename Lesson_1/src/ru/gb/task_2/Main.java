package ru.gb.task_2;

public class Main {
    public static void main(String[] args) {
        runMain();
    }

    public static void runMain() {
        Car lorry = new Lorry();
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();

        System.out.println();

        Car lightWeightCar = new LightWeightCar();
        lightWeightCar.open();
        lightWeightCar.start();
        lightWeightCar.move();
        lightWeightCar.stop();
    }
}
