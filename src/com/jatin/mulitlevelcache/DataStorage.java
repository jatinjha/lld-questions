package com.jatin.mulitlevelcache;

public interface DataStorage <K,V>{
    V getKey(K key);
    void putKey(K key , V value);
    void deleteKey(K key);
    boolean keyExists(K key);
    int getSize();

}
