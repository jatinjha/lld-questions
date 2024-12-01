package com.jatin.mulitlevelcache;

import com.jatin.mulitlevelcache.exception.InvalidKey;

public interface KeyEvictionPolicy<K> {
    K evictKey() throws InvalidKey;
    void keyAccessed(K k);
    void removeKey(K k) throws InvalidKey;
}
