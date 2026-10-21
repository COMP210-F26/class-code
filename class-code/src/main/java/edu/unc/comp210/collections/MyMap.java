package edu.unc.comp210.collections;

public interface MyMap<K, V> {

    int size();

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);
}
