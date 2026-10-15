package edu.unc.comp210.collections;

public interface MyCollection<E> {

    int size();

    boolean add(E elem);

    boolean remove(E elem);

    boolean contains(E elem);
}
