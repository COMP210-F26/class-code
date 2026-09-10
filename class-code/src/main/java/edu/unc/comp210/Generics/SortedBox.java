package edu.unc.comp210.Generics;

import java.util.ArrayList;
import java.util.List;

public class SortedBox<T extends Comparable> implements IBox<T> {

    private List<T> items = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public void put(T thing) {
        if (thing == null) {
            throw new IllegalArgumentException("no nulls in the box");
        }

        int index = 0;
        while (index < this.items.size()
                && this.items.get(index).compareTo(thing) <= 0) {
            index++;
        }

        this.items.add(index, thing);
    }

    @Override
    public T peek() {
        return this.items.get(0);
    }

    @Override
    public T take() {
        return this.items.remove(0);
    }
}
