package com.jatin.mulitlevelcache;

import com.jatin.mulitlevelcache.exception.InvalidCacheSize;
import com.jatin.mulitlevelcache.exception.InvalidKey;
import com.sun.jdi.Value;

public class CacheStorage<K,V> {
    DataStorage<K,V> dataStorage;
    KeyEvictionPolicy<K> keyEvictionPolicy;
    int cacheSize;

    public CacheStorage(DataStorage<K,V> dataStorage , KeyEvictionPolicy<K> keyEvictionPolicy , int cacheSize) throws InvalidCacheSize {
        if(cacheSize <= 0){
            throw new InvalidCacheSize("invalid size of cache");
        }
        this.dataStorage = dataStorage;
        this.keyEvictionPolicy = keyEvictionPolicy;
        this.cacheSize = cacheSize;
    }

    public V get(K key) throws InvalidKey {
        if(dataStorage.keyExists(key)){
            this.keyEvictionPolicy.removeKey(key);
            return dataStorage.getKey(key);
        }

        throw new InvalidKey("invalid Key");
    }

    public void put(K key , V value) throws InvalidKey {
        if(dataStorage.keyExists(key)){
            try{
                keyEvictionPolicy.removeKey(key);
                keyEvictionPolicy.keyAccessed(key);
                dataStorage.putKey(key,value);
                return;
            }catch (Exception ex){
                System.out.println("key not found exception {} "+ex.getMessage());
            }
        }
        if(dataStorage.getSize()>=cacheSize){
            System.out.println(" cache has reached it's limit evicting keys");
            K evictedNode = keyEvictionPolicy.evictKey();
            dataStorage.deleteKey(evictedNode);
        }

        dataStorage.putKey(key,value);
        keyEvictionPolicy.keyAccessed(key);
    }


}
