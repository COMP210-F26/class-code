package edu.unc.comp210.List;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> headNode = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E elem) {
        add(size,elem);
    }

    @Override
    public void add(int idx, E elem) {
        checkBounds(idx,size);
        Node<E> newNode =  new NodeImpl<>(elem);
        size++;

        if(idx == 0){
            //make it the new head
            newNode.setNext(this.headNode);
            this.headNode = newNode;
        }else{
            Node<E> prev = this.getNode(idx-1);
            Node<E> next = prev.getNext();

            newNode.setNext(next);
            prev.setNext(newNode);
        }


    }

    @Override
    public E remove(int idx) {
        checkBounds(idx, size-1);


        E retVal;
        if(idx==0){
            retVal = this.headNode.getValue();
            this.headNode = this.headNode.getNext();
        }else{
            Node<E> prev = this.getNode(idx-1);
            Node<E> toRemove = prev.getNext();

            retVal = toRemove.getValue();
            prev.setNext(toRemove.getNext());

        }
        size--;

        return retVal;
    }

    @Override
    public E get(int idx) {
        checkBounds(idx,size-1);
        return getNode(idx).getValue();
    }

    @Override
    public int indexOf(E elem) {
        int i=0;
        for(Node<E> cur = headNode; cur != null; cur = cur.getNext(),i++){
            if(cur.getValue().equals(elem)){
                return i;
            }
        }

         return -1; // nothing was found
    }

    private void checkBounds(int idx, int upperBound){
        if(idx < 0 || idx > upperBound){
            String msg = "Invalid idx: " + idx;
            throw new IndexOutOfBoundsException(msg);
        }
    }

    private Node<E> getNode(int idx){
        checkBounds(idx,size-1);

        Node<E> cur = headNode;
        for(int i=0;i<idx; i++){
            cur  = cur.getNext();
        }

        return cur;
    }

}