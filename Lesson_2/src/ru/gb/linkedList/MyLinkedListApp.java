package ru.gb.linkedList;

public class MyLinkedListApp {

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        MyLinkedList<Integer> linkList = new MyLinkedList<>();
        linkList.addFirst(1);
        linkList.addLast(2);
        linkList.addLast(3);
        linkList.addLast(4);
        linkList.addLast(5);
        linkList.addFirst(100);
        linkList.addFirst(23626);
        linkList.addLast(235);
        linkList.addFirst(3256);
        linkList.displayList();
        System.out.println("FirstElement = " + linkList.getFirstElement());
        System.out.println("LastElement = " + linkList.getLastElement());
        System.out.println("size = " + linkList.getSize());
        System.out.println("Removing last element");
        linkList.removeLast();
        linkList.displayList();
        System.out.println("LastElement = " + linkList.getLastElement());
        System.out.println("size = " + linkList.getSize());
        System.out.println("Removing first element");
        linkList.removeFirst();
        linkList.displayList();
        System.out.println("FirstElement = " + linkList.getFirstElement());
        System.out.println("size = " + linkList.getSize());
    }
}
