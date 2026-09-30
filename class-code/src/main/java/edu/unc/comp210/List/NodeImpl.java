package edu.unc.comp210.List;

public class NodeImpl<E> implements Node<E> {
    private E value;
    private Node<E> next;

    public NodeImpl(E value){
        this.value = value;
        this.next = null;
    }

    public NodeImpl(E value, Node<E> next){
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
    public Node<E> getNext() {
        return this.next;
    }

    @Override
    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Node)) {
            return false;
        }
        return (this.value.equals(((Node<E>)o).getValue()));
    }

}
