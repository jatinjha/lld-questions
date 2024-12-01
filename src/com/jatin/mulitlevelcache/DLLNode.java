package com.jatin.mulitlevelcache;

public class DLLNode<V> {
    DLLNode<V> prev;
    DLLNode<V> next;
    V value;

    public DLLNode(V value){
        this.value = value;
        prev = null;
        next = null;
    }
}
