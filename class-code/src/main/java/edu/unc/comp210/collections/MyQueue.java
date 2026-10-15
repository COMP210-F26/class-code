package edu.unc.comp210.collections;

public interface MyQueue<E> extends MyWorklist<E> {

    boolean offer(E elem);

    E poll();
}
