package ru.gb.task_3;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь круга: " + getArea());
    }
}
