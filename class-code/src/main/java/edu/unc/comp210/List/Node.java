package edu.unc.comp210.List;

public interface Node<E>{

    E getValue();

    void setValue(E value);

    Node<E> getNext();

    void setNext(Node<E> next);

    default boolean hasNext() {
        return (getNext() != null);
    }
}