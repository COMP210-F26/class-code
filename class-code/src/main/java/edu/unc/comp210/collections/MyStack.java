package edu.unc.comp210.collections;

public interface MyStack<E> extends MyWorklist<E> {

    void push(E elem);

    E pop();
}
