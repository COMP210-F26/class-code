package edu.unc.comp210.Generics;

public class Box<T> implements IBox<T> {

    private T item = null;

    @Override
    public boolean isEmpty() {
        return (item == null);
    }

    @Override
    public void put(T thing) {
        this.item = thing;
    }

    @Override
    public T peek() {
        return this.item;
    }

    @Override
    public T take() {
        return null;
    }
}
