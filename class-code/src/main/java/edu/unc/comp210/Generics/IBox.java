package edu.unc.comp210.Generics;

public interface IBox<E> {
    /** @return true when the box holds nothing */
    public boolean isEmpty();
    public void put(E thing);
    public E peek();
    public E take();

}
