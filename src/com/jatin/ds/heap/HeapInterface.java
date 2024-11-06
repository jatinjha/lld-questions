package com.jatin.ds.heap;

public interface HeapInterface<T> {
    public void addElement(T ele);
    public void heapify(int idx);
    public T getTop();
    public int getSize();
}
