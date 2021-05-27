package ru.gb.task_3;

public class FigureApp {
    public static void main(String[] args) {
        solveArea(createFigures());
    }

    public static Figure[] createFigures() {
        Figure[] figures = new Figure[3];

        figures[0] = new Circle(5.0);
        figures[1] = new Square(6.0);
        figures[2] = new Triangle(3.0, 4.0, 5.0);

        return figures;
    }

    public static void solveArea(Figure[] figures) {
        for (Figure figure : figures) {
            figure.printArea();
        }
    }
}
