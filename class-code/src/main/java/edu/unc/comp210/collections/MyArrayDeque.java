package edu.unc.comp210.collections;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayDeque<E> implements MyStack<E>, MyQueue<E> {
    private static final int INITIAL_CAPACITY = 10;

    private E[] data;
    private int front; // array index of the first element
    private int size;

    public MyArrayDeque() {
        this.data = (E[]) (new Object[INITIAL_CAPACITY]);
        this.front = 0;
        this.size = 0;
    }

    // ----- MyCollection -----

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E elem) {
        return offer(elem);
    }

    @Override
    public boolean contains(E elem) {
        for (int i = 0; i < size; i++) {
            if (elem.equals(data[index(i)])) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean remove(E elem) {
        for (int i = 0; i < size; i++) {
            if (elem.equals(data[index(i)])) {
                // shift everything after it one slot toward the front
                for (int j = i; j < size - 1; j++) {
                    data[index(j)] = data[index(j + 1)];
                }
                data[index(size - 1)] = null;
                size--;
                return true;
            }
        }
        return false; // nothing was found
    }


    // ----- MyStack -----

    @Override
    public void push(E elem) {
        addFirst(elem);
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("pop from an empty stack");
        }
        return removeFirst();
    }

    // ----- MyQueue -----

    @Override
    public boolean offer(E elem) {
        addLast(elem);
        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        return removeFirst();
    }

    // ----- MyWorklist, shared by both -----

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("remove from an empty deque");
        }
        return removeFirst();
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return data[front];
    }

    // ----- private deque operations -----

    private int index(int i) {
        return (front + i) % data.length;
    }

    private void addFirst(E elem) {
        if (size == data.length) {
            grow();
        }
        // step front back one slot, wrapping from 0 to the end of the array
        front = (front - 1 + data.length) % data.length;
        data[front] = elem;
        size++;
    }

    private void addLast(E elem) {
        if (size == data.length) {
            grow();
        }
        data[index(size)] = elem;
        size++;
    }

    private E removeFirst() {
        E removed = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return removed;
    }

    private E removeLast() {
        int last = index(size - 1);
        E removed = data[last];
        data[last] = null;
        size--;
        return removed;
    }

    private void grow() {
        E[] bigger = (E[]) new Object[data.length * 2];
        // unwrap: copy in logical order so the front lands at index 0
        for (int i = 0; i < size; i++) {
            bigger[i] = data[index(i)];
        }
        this.data = bigger;
        this.front = 0;
    }

    public static void main(String[] args){
        System.out.println((-1 + 8) % 8);
        System.out.println(Math.floorMod(-1, 8));
        System.out.println(Math.abs(-1) % 8);
    }


}
