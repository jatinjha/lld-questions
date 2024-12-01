package com.jatin.mulitlevelcache;

import com.jatin.mulitlevelcache.exception.InvalidKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUEvictionPolicy<K> implements KeyEvictionPolicy<K>{

    Map<K,DLLNode<K>> policyStorage = new HashMap<>();
    DoublyLinkedList<K> doublyLinkedList = new DoublyLinkedList<>();
    @Override
    public K evictKey() throws InvalidKey {
        DLLNode<K> dllNode = doublyLinkedList.getTail().prev;

        if(Objects.isNull(dllNode)){
            throw new InvalidKey("key not found");
        }

        doublyLinkedList.removeNode(dllNode);
        policyStorage.remove(dllNode.value);

        return dllNode.value;
    }

    @Override
    public void keyAccessed(K k) {
        DLLNode dllNode = new DLLNode(k);
        policyStorage.put(k,dllNode);
        doublyLinkedList.addNode(dllNode);
    }

    @Override
    public void removeKey(K k) throws InvalidKey{
        DLLNode<K> dllNode = policyStorage.get(k);
        if(Objects.isNull(dllNode)){
            throw new InvalidKey("key not present in dll");
        }

        doublyLinkedList.removeNode(dllNode);

    }
}
