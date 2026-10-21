package edu.unc.comp210.collections;

 class KeyValuePair<K, V> {
    private final K key; // final: changing a key would leave the pair in the wrong bucket
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
