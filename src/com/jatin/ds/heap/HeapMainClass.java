package com.jatin.ds.heap;

public class HeapMainClass {
    public static void main(String[] args) {
        HeapInterface<Integer> maxHeap = new MaxHeapImplementation();
        maxHeap.addElement(10);
        maxHeap.addElement(-23);
        maxHeap.addElement(11);
        maxHeap.addElement(12);
        maxHeap.addElement(19);
        maxHeap.addElement(7);
        maxHeap.addElement(8);
        maxHeap.addElement(9);

        while (maxHeap.getSize()>0){
            System.out.println(maxHeap.getTop());
        }

    }
}
