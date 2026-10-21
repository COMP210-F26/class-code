package edu.unc.comp210.collections;

public class MyHashSet<E> implements MySet<E> {
    private MyHashMap<E, Boolean> map; // the elements are the keys; the values are ignored

    public MyHashSet() {
        this.map = new MyHashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E elem) {
        return map.put(elem, true) == null; // null means elem was not already a key
    }

    @Override
    public boolean remove(E elem) {
        return map.remove(elem) != null;
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }
}
