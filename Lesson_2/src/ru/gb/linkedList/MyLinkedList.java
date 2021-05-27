package ru.gb.linkedList;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public MyLinkedList() {
    }

    public void addFirst(E val) {
        Node<E> next = first;
        Node<E> newNode = new Node<>(val, null, next);
        first = newNode;
        if (next == null) {
            last = newNode;
        } else {
            next.prev = newNode;
        }
        size++;
    }

    public void addLast(E val) {
        Node<E> prev = last;
        Node<E> newNode = new Node<>(val, prev, null);
        last = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    public void removeFirst() {
        Node<E> remFirst = first;
        Node<E> nextElement = remFirst.next;
        remFirst.val = null;
        remFirst.next = null;
        first = nextElement;
        nextElement.prev = null;
        size--;
    }
    public void removeLast() {
        Node<E> remLast = last;
        Node<E> prevElement = remLast.prev;
        remLast.val = null;
        remLast.prev = null;
        last = prevElement;
        prevElement.next = null;
        size--;
    }

    public void displayList() {
        Node<E> current = first;
        while (current != null) {
            current.printNode();
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public E getFirstElement() {
        Node<E> firstElement = first;
        return firstElement.val;
    }

    public E getLastElement() {
        Node<E> lastElement = last;
        return lastElement.val;
    }


    public static class Node<E> {
        private E val;
        private Node<E> prev;
        private Node<E> next;

        public Node(E val, Node<E> prev, Node<E> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public void printNode() {
            System.out.print(val + " ");
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
