package edu.unc.comp210.collections;

public interface MyList<E> extends MyCollection<E> {

    void add(int idx, E elem);

    E remove(int idx);

    E get(int idx);

    int indexOf(E elem);
}
