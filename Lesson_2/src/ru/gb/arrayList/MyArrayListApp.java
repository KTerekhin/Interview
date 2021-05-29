package ru.gb.arrayList;

public class MyArrayListApp {
    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        MyArrayList<Integer> list = new MyArrayList<>();

        System.out.println("Size = " + list.getSize());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.toString());
        System.out.println("New size = " + list.getSize());

        list.add(8, 2);

        System.out.println(list.toString());
        System.out.println("New size = " + list.getSize());

        System.out.println();

        System.out.println((list.get(5)));

        System.out.println("Removing element: " + list.remove(2).toString());
        System.out.println("New size = " + list.getSize());

        System.out.println(list.toString());

        list.setNewValue(10, 5);
        System.out.println(list.toString());
    }
}
