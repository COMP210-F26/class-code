package edu.unc.comp210.List;

public class NodeImpl<E> implements Node<E> {
    private E value;
    private Node next;

    public NodeImpl(E value){
        this.value = value;
        this.next = null;
    }

    public NodeImpl(E value, Node next){
        this.value = value;
        this.next = next;
    }

    @Override
    public E getValue() {
        return this.value;
    }

    @Override
    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }
}
