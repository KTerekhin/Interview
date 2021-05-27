package ru.gb.arrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E value) {
        if (size == elements.length) {
            elements = ensureCapacity();
        }
        elements[size] = value;
        size++;
    }

    public void add(E val, int index) {
        isIndexExist(index);
        if (size == elements.length) {
            elements = ensureCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = val;
        size++;
    }

    public Object get(int index) {
        isIndexExist(index);
        return elements[index];
    }

    public int getSize() {
        return size;
    }

    public Object remove(int index) {
        isIndexExist(index);
        Object[] temp = elements;
        elements = new Object[temp.length - 1];
        Object value = temp[index];
        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);
        size--;
        return value;
    }

    public void setNewValue(E value, int index) {
        isIndexExist(index);
        for (int i = 0; i < elements.length; i++) {
            if (i == index) {
                elements[i] = value;
            }
        }
    }

    private Object[] ensureCapacity() {
        Object[] temp = new Object[(elements.length) * 2];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        return temp;
    }

    private void isIndexExist(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Указанный индекс выходит за пределы списка от 0 до " + (size - 1));
        }
    }

    @Override
    public String toString() {
        Object[] temp = new Object[size];
        System.arraycopy(elements, 0, temp, 0, size);
        return Arrays.toString(temp);
    }
}
