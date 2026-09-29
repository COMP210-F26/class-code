package edu.unc.comp210.List;

public interface Node<E>{

    E getValue();

    void setValue(E value);

    Node getNext();

    void setNext(Node next);

    default boolean hasNext() {
        return (getNext() != null);
    }
}