package com.jatin.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapImplementation implements HeapInterface<Integer>{
    private List<Integer> heap;

    private int getParent(int idx){
        return (idx-1)/2;
    }

    private int getLeftChild(int idx){
        return 2*idx+1;
    }

    private int getRightChild(int idx){
        return 2*idx+2;
    }

    public MaxHeapImplementation(){
        heap = new ArrayList<>();
    }


    @Override
    public void addElement(Integer ele) {
        heap.add(heap.size(),ele);
        int currIdx = heap.size()-1;
        while(currIdx>0 && heap.get(getParent(currIdx))<=heap.get(currIdx)){
            int currVal = heap.get(currIdx);
            int parVal = heap.get(getParent(currIdx));
            heap.set(currIdx,parVal);
            heap.set(getParent(currIdx),currVal);
            currIdx = getParent(currIdx);
        }
    }

    @Override
    public void heapify(int indx) {
        int leftIdx = getLeftChild(indx);
        int rightIdx = getRightChild(indx);
        int orgIdx = indx;

        if(leftIdx<heap.size() && heap.get(leftIdx)>heap.get(indx)){
            indx = leftIdx;
        }

        if(rightIdx<heap.size() && heap.get(rightIdx)>heap.get(indx)){
            indx = rightIdx;
        }

        if(indx!=orgIdx){
            int temp = heap.get(orgIdx);
            heap.set(orgIdx,heap.get(indx));
            heap.set(indx,temp);
            heapify(indx);
        }

    }

    @Override
    public Integer getTop() {
        if(heap.size()==0){
            System.out.println("no element found");
            return null;
        }

        int topEle = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapify(0);
        return topEle;
    }

    public int getSize(){
        return heap.size();
    }

}
