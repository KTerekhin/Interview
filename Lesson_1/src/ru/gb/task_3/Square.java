package ru.gb.task_3;

public class Square extends Figure {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь квадрата: " + getArea());
    }
}
