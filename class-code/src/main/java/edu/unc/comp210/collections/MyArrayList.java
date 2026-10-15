package edu.unc.comp210.collections;

public class MyArrayList<E> implements MyList<E> {
    private static final int INITIAL_CAPACITY=10;

    private E[] data;
    private int size;

    public MyArrayList(){
        this.data = (E[])(new Object[INITIAL_CAPACITY]);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E elem) {
        add(size,elem);
        return true;
    }

    @Override
    public void add(int idx, E elem) {
        if(idx < 0 || idx > size){
            throw new IndexOutOfBoundsException("invalid idx: " + idx + " size: " + size);
        }

        if(size == data.length){
            grow();
        }

        //shift everything to the right one slot starting at the end.
        for(int i = size; i > idx; i--){
            data[i] = data[i-1];
        }

        data[idx] = elem;
        this.size++;

    }

    @Override
    public E remove(int idx) {
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }
        //grab return item
        E removed = data[idx];

        //Shift everything to the left to remove blank spot
        for(int i=idx;i<size-1; i++){
            data[i] = data[i+1];
        }

        this.size--;
        this.data[size] = null;

        return removed;
    }

    @Override
    public E get(int idx) {
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }
        return this.data[idx];
    }

    @Override
    public int indexOf(E elem) {
        for(int i=0; i< size; i++){
            if(elem.equals(this.data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(E elem) {
        int idx = indexOf(elem);
        if(idx == -1){
            return false; // nothing to remove
        }
        remove(idx);
        return true;
    }

    @Override
    public boolean contains(E elem) {
        return indexOf(elem) != -1;
    }

    private void grow(){
        //create an array that is double the size
        E[] bigger = (E[]) new Object[this.data.length*2];
        //copy all items over to the new array
        for(int i=0; i<size; i++){
            bigger[i] = this.data[i];
        }
        //set it as an instance variable.
        this.data = bigger;
    }

    @Override
    public String toString(){
        String result = "[";
        for(int i=0; i<size; i++){
            if(i > 0){
                result += ", ";
            }
            result += this.data[i];
        }
        result += "]";
        return result;
    }
}
