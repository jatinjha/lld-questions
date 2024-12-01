package com.jatin.mulitlevelcache;

import java.util.HashMap;
import java.util.Map;

public class InMeomoryDataStorage<K,V> implements DataStorage<K,V>{
    private Map<K,V> inMemoryCache = new HashMap<>();
    @Override
    public V getKey(K key) {
        if(inMemoryCache.containsKey(key)){
            return inMemoryCache.get(key);
        }
        return null;
    }

    @Override
    public void putKey(K key, V value) {
        inMemoryCache.put(key,value);
    }

    @Override
    public void deleteKey(K key) {
        if(inMemoryCache.containsKey(key)){
            inMemoryCache.remove(key);
        }
    }

    @Override
    public boolean keyExists(K key) {
        return inMemoryCache.containsKey(key);
    }

    @Override
    public int getSize() {
        return inMemoryCache.size();
    }
}
